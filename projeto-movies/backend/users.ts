export class User {
    constructor(public email: string,
        public name: string,
        public password: string) { }

    matches(another: User): boolean {
        return another !== undefined &&
            another.email === this.email &&
            another.password === this.password
    }
}
export const users: { [key: string]: User } = {
    "andreps25@gmail.com": new User('andreps25@gmai.com', 'André', 'andrepauli')
}