import { Pessoa } from "./pessoa";

export class Secretaria extends Pessoa {
    salario! : number
    dataContratacao! : Date
    pis! : string

    constructor() {
        super()
        this.ativo = true
    }
}