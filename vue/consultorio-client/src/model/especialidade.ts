import { AbstractEntity } from "./abstract-entity";


export class Especialidade extends AbstractEntity{
    nome! : string

    constructor() {
        super()
        this.ativo = true
    }
}