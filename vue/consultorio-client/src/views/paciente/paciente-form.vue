<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Paciente
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
                <input v-model="paciente.ativo" checked type="checkbox">
                Ativar Paciente
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.nome" placeholder="Nome do paciente">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Telefone</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.telefone" placeholder="Telefone">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Celular</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.celular" placeholder="Celular">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nacionalidade</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.nacionalidade" placeholder="Nacionalidade">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">CPF</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.cpf" placeholder="CPF">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">RG</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.rg" placeholder="RG">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">E-mail</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.email" placeholder="E-mail">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Login</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.login" placeholder="Login">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Senha</label>
            <div class="control">
                <input class="input is-primary" type="password" v-model="paciente.senha" placeholder="Senha">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Sexo</label>
            <div class="control">
                <select v-model="paciente.sexo">
                  <option>masculino</option>
                  <option>feminino</option>
                  <option>outro</option>
                </select>
            </div>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Tipo Atendimento</label>
            <div class="control">
               <select v-model="paciente.tipoAtendimento">
                  <option>particular</option>
                  <option>convenio</option>
                </select>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Cartao Convenio</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.numeroCartaoConvenio" placeholder="Cartao Convenio">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Data Vencimento</label>
            <div class="control">
                <input class="input is-primary" type="datetime-local" v-model="paciente.dataVencimento" placeholder="Data Vencimento">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Convenio</label>
            <div class="control">
                <input class="input is-primary" type="number" v-model="idConvenio" placeholder="Convenio">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/paciente/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Salvar</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Paciente } from '@/model/paciente'
    import { Notification } from '@/model/notification'
    import { PacienteClient } from '@/client/paciente.client'
    import { ConvenioClient } from '@/client/convenio.client';

    export default class PacienteForm extends Vue {

        private pacienteClient!: PacienteClient
        private convenioClient!: ConvenioClient
        private paciente : Paciente = new Paciente()
        private notification : Notification = new Notification()
        private idConvenio!: number
    
        public mounted(): void {
            this.pacienteClient = new PacienteClient()
            this.convenioClient = new ConvenioClient()
            this.getConvenio()
        }
        
        private onClickCadastrar(): void {
            console.log(this.idConvenio, this.paciente.convenio)
            this.getConvenio()
            this.pacienteClient.cadastrar(this.paciente)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Paciente Cadastrado com sucesso!!!')
                    this.onClickLimpar()
                }, error => {
                    this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                    this.onClickLimpar()
                })
        }

        private getConvenio(): void {
            if (this.idConvenio) {
                this.convenioClient.findById(this.idConvenio)
                    .then(
                        success => {
                            this.paciente.convenio.id =  success.id
                            this.paciente.convenio.nome = success.nome
                            this.paciente.convenio.valor = success.valor
                            this.paciente.convenio.ativo = success.ativo
                            this.paciente.convenio.cadastro = success.cadastro
                            this.paciente.convenio.atualizado = success.atualizado
                        },
                        error => console.log(error)
                    )
            }
            
        }

        private onClickFecharNotificacao(): void {
            this.notification = new Notification()
        }

        private onClickLimpar(): void {
            this.paciente = new Paciente()
        }

    }
</script>