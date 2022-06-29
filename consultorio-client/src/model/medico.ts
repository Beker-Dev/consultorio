import { Pessoa } from "./pessoa";
import { Especialidade } from "./especialidade";

export class Medico extends Pessoa {
    crm! : string
    consultorio! : string
    porcentagemParticipacao! : number
    valorConsulta! : number
    especialidade! : Especialidade
}