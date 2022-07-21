<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Secretaria
        </div>
    </div>

    <hr />

    <div class="columns" v-if="notification.ativo">
        <div class="column is-12">
            <div :class="notification.classe">
                <button @click="onClickFecharNotificacao()" class="delete" ></button>
                {{ notification.mensagem }}
            </div>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">
                <input v-model="secretaria.ativo" checked type="checkbox">
                Ativar Secretaria
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.nome" placeholder="Nome da Secretaria">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Telefone</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.telefone" placeholder="Telefone">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Celular</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.celular" placeholder="Celular">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nacionalidade</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.nacionalidade" placeholder="Nacionalidade">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">CPF</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.cpf" placeholder="CPF">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">RG</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.rg" placeholder="RG">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">E-mail</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.email" placeholder="E-mail">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Login</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.login" placeholder="Login">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Senha</label>
            <div class="control">
                <input class="input is-primary" type="password" v-model="secretaria.senha" placeholder="Senha">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Sexo</label>
            <div class="control">
               <select v-model="secretaria.sexo">
                  <option>masculino</option>
                  <option>feminino</option>
                  <option>outro</option>
                </select>
            </div>
        </div>
    </div>

     <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Salario</label>
            <div class="control">
                <input class="input is-primary" type="number" v-model="secretaria.salario" placeholder="Salario">
            </div>
        </div>
    </div> <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Data Contratacao</label>
            <div class="control">
                <input class="input is-primary" type="datetime-local" v-model="secretaria.dataContratacao" placeholder="Data Contratacao">
            </div>
        </div>
    </div> <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Pis</label>
            <div class="control">
                <input class="input is-primary" type="number" v-model="secretaria.pis" placeholder="Pis">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/secretaria/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Salvar</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Secretaria } from '@/model/secretaria'
    import { Notification } from '@/model/notification'
    import { SecretariaClient } from '@/client/secretaria.client'

    export default class SecretariaForm extends Vue {

        private secretariaClient!: SecretariaClient
        private secretaria : Secretaria = new Secretaria()
        private notification : Notification = new Notification()
    
        public mounted(): void {
            this.secretariaClient = new SecretariaClient()
        }
        
        private onClickCadastrar(): void {

            this.secretariaClient.cadastrar(this.secretaria)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Secretaria Cadastrada com sucesso!!!')
                    this.onClickLimpar()
                }, error => {
                    this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                    this.onClickLimpar()
                })
        }

        private onClickFecharNotificacao(): void {
            this.notification = new Notification()
        }

        private onClickLimpar(): void {
            this.secretaria = new Secretaria()
        }

        // private created(): void { }
    }
</script>