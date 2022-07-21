import { AbstractEntity } from "./abstract-entity";
import { StatusAgenda } from "./status-agenda";
import { Paciente } from "./paciente";
import { Secretaria } from "./secretaria";
import { Medico } from "./medico";


export class Agenda extends AbstractEntity{
    status! : StatusAgenda
    dataDe! : Date
    dataAte! : Date
    encaixe! : boolean
    paciente! : Paciente
    secretaria! : Secretaria
    medico! : Medico
}