import { AbstractEntity } from "./abstract-entity.model";
import { Agenda } from "./agenda.model";
import { Paciente } from "./paciente.model";
import { Secretaria } from "./secretaria.model";
import { StatusAgenda } from "./status-agenda.enum";

export class Historico extends AbstractEntity {
    data! : Date
    statusAgenda! : StatusAgenda
    observacao! : string
    secretaria! : Secretaria
    paciente! : Paciente
    agenda! : Agenda
}