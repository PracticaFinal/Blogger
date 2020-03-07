import { OK, BAD_REQUEST } from 'http-status-codes';
import { Controller, Middleware, Get, Post, Put, Delete } from '@overnightjs/core';
import { Request, Response } from 'express';
import { Logger } from '@overnightjs/logger';
import { JwtManager, ISecureRequest } from '@overnightjs/jwt';

@Controller('api/users')
export class UserController {
 
    @Get('holi/hola:p')
    private get(req: Request, res: Response) {
        Logger.Info(req.params.id);
        
        return res.status(OK).json({
            message: 'get_called x'+req.params.p,
        });
    }
 
    @Get('token/get:x')
    private getJwt(req: Request, res: Response){
        /*const tokensito = JwtManager.jwt({
            nombre: req.params.x
        });*/
        var jwt = require('jsonwebtoken');
        var tokensito = jwt.sign({
            nombre: req.params.x
        },'Secretin secretado, este Secreto esta Encriptado',{algorithm: 'HS256'});
        return res.status(OK).json({
            jwt: tokensito,
        });
    }
    @Get('')
    //@Middleware([middleware1, middleware2])
    private getAll(req: Request, res: Response) {
        Logger.Info(req, true);
       /* let key = "hola123";
        let token = jwt.sig*/
        return res.status(OK).json({
            token: 'get_all_called',
        });
    }
 
    @Post()
    private add(req: Request, res: Response) {
        Logger.Info(req.body, true);
        return res.status(OK).json({
            message: 'add_called',
        });
    }
 
    @Put('update-user')
    private update(req: Request, res: Response) {
        Logger.Info(req.body);
        return res.status(OK).json({
            message: 'update_called',
        });
    }
 
    @Delete('delete/:id')
    private delete(req: Request, res: Response) {
        Logger.Info(req.params, true);
        return res.status(OK).json({
            message: 'delete_called',
        });
    }
 
    @Get(/ane/) // Rexes supported. Matches /lane, /cane, etc.
    public getAne(req: Request, res: Response): any {
        return res.status(OK).json({
            message: '/ane/',
        });
    }
 
    @Get('practice/async')
    private async getWithAsync(req: Request, res: Response) {
        try {
            const asyncMsg = await this.asyncMethod(req);
            return res.status(OK).json({
                message: asyncMsg,
            });
        } catch (err) {
            Logger.Err(err, true);
            return res.status(BAD_REQUEST).json({
                error: err.message,
            });
        }
    }
 
    private asyncMethod(req: Request): Promise<string> {
        return new Promise((resolve) => {
            resolve(req.originalUrl + ' called');
        });
    }
}