"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var tslib_1 = require("tslib");
var http_status_codes_1 = require("http-status-codes");
var core_1 = require("@overnightjs/core");
var logger_1 = require("@overnightjs/logger");
var UserController = (function () {
    function UserController() {
    }
    UserController.prototype.get = function (req, res) {
        logger_1.Logger.Info(req.params.id);
        return res.status(http_status_codes_1.OK).json({
            message: 'get_called x' + req.params.p,
        });
    };
    UserController.prototype.getJwt = function (req, res) {
        var jwt = require('jsonwebtoken');
        var tokensito = jwt.sign({
            nombre: req.params.x
        }, 'Secretin secretado, este Secreto esta Encriptado', { algorithm: 'HS256' });
        return res.status(http_status_codes_1.OK).json({
            jwt: tokensito,
        });
    };
    UserController.prototype.getAll = function (req, res) {
        logger_1.Logger.Info(req, true);
        return res.status(http_status_codes_1.OK).json({
            token: 'get_all_called',
        });
    };
    UserController.prototype.add = function (req, res) {
        logger_1.Logger.Info(req.body, true);
        return res.status(http_status_codes_1.OK).json({
            message: 'add_called',
        });
    };
    UserController.prototype.update = function (req, res) {
        logger_1.Logger.Info(req.body);
        return res.status(http_status_codes_1.OK).json({
            message: 'update_called',
        });
    };
    UserController.prototype.delete = function (req, res) {
        logger_1.Logger.Info(req.params, true);
        return res.status(http_status_codes_1.OK).json({
            message: 'delete_called',
        });
    };
    UserController.prototype.getAne = function (req, res) {
        return res.status(http_status_codes_1.OK).json({
            message: '/ane/',
        });
    };
    UserController.prototype.getWithAsync = function (req, res) {
        return tslib_1.__awaiter(this, void 0, void 0, function () {
            var asyncMsg, err_1;
            return tslib_1.__generator(this, function (_a) {
                switch (_a.label) {
                    case 0:
                        _a.trys.push([0, 2, , 3]);
                        return [4, this.asyncMethod(req)];
                    case 1:
                        asyncMsg = _a.sent();
                        return [2, res.status(http_status_codes_1.OK).json({
                                message: asyncMsg,
                            })];
                    case 2:
                        err_1 = _a.sent();
                        logger_1.Logger.Err(err_1, true);
                        return [2, res.status(http_status_codes_1.BAD_REQUEST).json({
                                error: err_1.message,
                            })];
                    case 3: return [2];
                }
            });
        });
    };
    UserController.prototype.asyncMethod = function (req) {
        return new Promise(function (resolve) {
            resolve(req.originalUrl + ' called');
        });
    };
    tslib_1.__decorate([
        core_1.Get('holi/hola:p'),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", void 0)
    ], UserController.prototype, "get", null);
    tslib_1.__decorate([
        core_1.Get('token/get:x'),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", void 0)
    ], UserController.prototype, "getJwt", null);
    tslib_1.__decorate([
        core_1.Get(''),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", void 0)
    ], UserController.prototype, "getAll", null);
    tslib_1.__decorate([
        core_1.Post(),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", void 0)
    ], UserController.prototype, "add", null);
    tslib_1.__decorate([
        core_1.Put('update-user'),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", void 0)
    ], UserController.prototype, "update", null);
    tslib_1.__decorate([
        core_1.Delete('delete/:id'),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", void 0)
    ], UserController.prototype, "delete", null);
    tslib_1.__decorate([
        core_1.Get(/ane/),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", Object)
    ], UserController.prototype, "getAne", null);
    tslib_1.__decorate([
        core_1.Get('practice/async'),
        tslib_1.__metadata("design:type", Function),
        tslib_1.__metadata("design:paramtypes", [Object, Object]),
        tslib_1.__metadata("design:returntype", Promise)
    ], UserController.prototype, "getWithAsync", null);
    UserController = tslib_1.__decorate([
        core_1.Controller('api/users')
    ], UserController);
    return UserController;
}());
exports.UserController = UserController;
//# sourceMappingURL=UserController.js.map