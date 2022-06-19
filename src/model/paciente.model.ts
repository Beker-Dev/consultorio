import { Pessoa } from "./pessoa.model";
import { TipoAtendimento } from "./tipo-atendimento.enum";
import { Convenio } from "./convenio.model";


export class Paciente extends Pessoa {
    tipoAtendimento! : TipoAtendimento
    numeroCartaoConvenio! : string
    dataVencimento!: Date
    convenio! : Convenio
}