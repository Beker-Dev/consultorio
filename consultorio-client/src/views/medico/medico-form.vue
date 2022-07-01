<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Medico
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
                <input v-model="medico.ativo" checked type="checkbox">
                Ativar Medico
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.nome" placeholder="Nome">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Telefone</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.telefone" placeholder="Telefone">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Celular</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.celular" placeholder="Celular">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nacionalidade</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.nacionalidade" placeholder="Nacionalidade">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">CPF</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.cpf" placeholder="CPF">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">RG</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.rg" placeholder="RG">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">E-mail</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.email" placeholder="E-mail">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Login</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.login" placeholder="Login">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Senha</label>
            <div class="control">
                <input class="input is-primary" type="password" v-model="medico.senha" placeholder="Senha">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Sexo</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.sexo" placeholder="Sexo">
            </div>
        </div>
    </div>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">CRM</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.crm" placeholder="CRM">
            </div>
        </div>
    </div>
        <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Consultorio</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.consultorio" placeholder="Consultorio">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Porcentagem Participacao</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.porcentagemParticipacao" placeholder="Porcentagem Participacao">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Valor Consulta</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.valorConsulta" placeholder="Valor Consulta">
            </div>
        </div>
    </div> 
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Especialidade</label>
            <div class="control">
                <input class="input is-primary" type="number" v-model="idEspecialidade" placeholder="Especialidade">
            </div>
        </div>
    </div>
     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/medico/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Success</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Medico } from '@/model/medico'
    import { Notification } from '@/model/notification'
    import { MedicoClient } from '@/client/medico.client'
    import { EspecialidadeClient } from '@/client/especialidade.client';

    export default class MedicoForm extends Vue {

        private especialidadeClient!: EspecialidadeClient
        private medicoClient!: MedicoClient
        private medico : Medico = new Medico()
        private notification : Notification = new Notification()
        private idEspecialidade!: number
    
        public mounted(): void {
            this.medicoClient = new MedicoClient()
            this.especialidadeClient = new EspecialidadeClient()
            this.getEspecialidade()
        }
        
        private onClickCadastrar(): void {
            this.medicoClient.cadastrar(this.medico)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Medico Cadastrado com sucesso!!!')
                    this.onClickLimpar()
                }, error => {
                    this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                    this.onClickLimpar()
                })
        }

        private getEspecialidade(): void {
            this.especialidadeClient.findById(this.idEspecialidade)
            .then(
                success => {
                    this.medico.especialidade.id = success.id
                    this.medico.especialidade.nome = success.nome
                    this.medico.especialidade.ativo = success.ativo
                    this.medico.especialidade.atualizado = success.atualizado
                    this.medico.especialidade.cadastro = success.cadastro
                },
                error => {
                    this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                }
            )
        }

        private onClickFecharNotificacao(): void {
            this.notification = new Notification()
        }

        private onClickLimpar(): void {
            this.medico = new Medico()
        }

        // private created(): void { }
    }
</script>