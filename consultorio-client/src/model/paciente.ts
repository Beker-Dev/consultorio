import { Pessoa } from "./pessoa";
import { TipoAtendimento } from "./tipo-atendimento";
import { Convenio } from "./convenio";


export class Paciente extends Pessoa {
    tipoAtendimento! : TipoAtendimento
    numeroCartaoConvenio! : string
    dataVencimento!: Date
    convenio! : Convenio

    constructor() {
        super()
        this.ativo = true
    }
}