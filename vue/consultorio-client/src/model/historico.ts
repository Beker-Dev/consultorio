import { AbstractEntity } from "./abstract-entity";
import { Agenda } from "./agenda";
import { Paciente } from "./paciente";
import { Secretaria } from "./secretaria";
import { StatusAgenda } from "./status-agenda";

export class Historico extends AbstractEntity {
    data! : Date
    statusAgenda! : StatusAgenda
    observacao! : string
    secretaria! : Secretaria
    paciente! : Paciente
    agenda! : Agenda
}