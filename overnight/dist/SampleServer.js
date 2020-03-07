"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var tslib_1 = require("tslib");
var bodyParser = require("body-parser");
var core_1 = require("@overnightjs/core");
var logger_1 = require("@overnightjs/logger");
var UserController_1 = require("./UserController");
var cors = require("cors");
var SampleServer = (function (_super) {
    tslib_1.__extends(SampleServer, _super);
    function SampleServer() {
        var _this = _super.call(this, process.env.NODE_ENV === 'development') || this;
        _this.app.use(bodyParser.json());
        _this.app.use(bodyParser.urlencoded({ extended: true }));
        var whitelist = ["http://localhost"];
        var options = {
            origin: whitelist,
            credentials: true,
            allowedHeaders: 'Authorization, Origin, X-Requested-With, Conten-Type, Accept',
            methods: 'POST, GET, DELETE, PUT, OPTIONS',
            maxAge: 3600
        };
        _this.app.use(cors(options));
        _this.setupControllers();
        return _this;
    }
    SampleServer.prototype.setupControllers = function () {
        var userController = new UserController_1.UserController();
        _super.prototype.addControllers.call(this, [userController]);
    };
    SampleServer.prototype.start = function (port) {
        this.app.listen(port, function () {
            logger_1.Logger.Imp('Server listening on port: ' + port);
        });
    };
    return SampleServer;
}(core_1.Server));
exports.SampleServer = SampleServer;
//# sourceMappingURL=SampleServer.js.map