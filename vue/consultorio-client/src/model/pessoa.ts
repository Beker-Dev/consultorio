import { AbstractEntity } from "./abstract-entity";
import { Sexo } from "./sexo";

export class Pessoa extends AbstractEntity {
    nome!: string
    telefone!: string
    celular!: string
    nacionalidade!: string
    cpf!: string
    rg!: string
    email!: string
    login!: string
    senha!: string
    sexo!: Sexo
}