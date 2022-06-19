import { AbstractEntity } from "./abstract-entity.model";
import { StatusAgenda } from "./status-agenda.enum";
import { Paciente } from "./paciente.model";
import { Secretaria } from "./secretaria.model";
import { Medico } from "./medico.model";


export class Agenda extends AbstractEntity{
    status! : StatusAgenda
    dataDe! : Date
    dataAte! : Date
    encaixe! : boolean
    paciente! : Paciente
    secretaria! : Secretaria
    medico! : Medico
}