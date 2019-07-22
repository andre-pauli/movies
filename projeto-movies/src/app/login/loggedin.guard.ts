import { CanLoad, Route, Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";
import { Injectable } from "@angular/core";
import { LoginService } from './loginService';

@Injectable()
export class LoggedInGuard implements CanLoad {

    constructor(private loginService: LoginService,
        private router: Router) { }

    checkAuthentication(path: string) {
        const loggedIn = this.loginService.isLoggedIn()
        if (!loggedIn) {
            this.loginService.handleLogin(`/${path}`)
        }
        return loggedIn;
    }

    canLoad(route: Route): boolean {
        return this.checkAuthentication(route.path)
    }

    canActivate(activateRoute: ActivatedRouteSnapshot, routerState: RouterStateSnapshot): boolean {
        return this.checkAuthentication(activateRoute.routeConfig.path)
    }

}