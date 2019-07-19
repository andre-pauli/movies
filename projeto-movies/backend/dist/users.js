"use strict";
exports.__esModule = true;
var User = /** @class */ (function () {
    function User(email, name, password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
    User.prototype.matches = function (another) {
        return another !== undefined &&
            another.email === this.email &&
            another.password === this.password;
    };
    return User;
}());
exports.User = User;
exports.users = {
    "andreps25@gmail.com": new User('andreps25@gmail.com', 'André', 'andrepauli'),
    "matheus@gmail.com": new User('matheus@gmail.com', 'Matheus', 'matheussouza'),
    "wagner25@gmail.com": new User('wagner@gmail.com', 'Wagner', 'wagnercardozo')
};
