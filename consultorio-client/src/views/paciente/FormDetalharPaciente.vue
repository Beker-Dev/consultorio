<template>
  <div class="container">
    <h1 class="titulo" >Detalhar Paciente</h1>
    <div class="field">
      <label class="label">Nome</label>
      <div class="control">
        <input class="input" type="text" placeholder="nome">
      </div>
    </div>

    <div class="field">
      <label class="label">Telefone</label>
      <div class="control">
        <input class="input" type="number" placeholder="telefone">
      </div>
    </div>

    <div class="field">
      <label class="label">Celular</label>
      <div class="control">
        <input class="input" type="number" placeholder="celular">
      </div>
    </div>

    <div class="field">
      <label class="label">Nacionalidade</label>
      <div class="control">
        <input class="input" type="text" placeholder="nacionalidade">
      </div>
    </div>

    <div class="field">
      <label class="label">CPF</label>
      <div class="control">
        <input class="input" type="number" placeholder="cpf">
      </div>
    </div>

    <div class="field">
      <label class="label">RG</label>
      <div class="control">
        <input class="input" type="number" placeholder="rg">
      </div>
    </div>

    <div class="field">
      <label class="label">Email</label>
      <div class="control">
        <input class="input" type="email" placeholder="e-mail">
      </div>
    </div>

    <div class="field">
      <label class="label">Login</label>
      <div class="control">
        <input class="input" type="text" placeholder="login">
      </div>
    </div>

    <div class="field">
      <label class="label">Senha</label>
      <div class="control">
        <input class="input" type="password" placeholder="senha">
      </div>
    </div>

    <div class="enums">
      <div class="enum-sexo">
        <label class="label">Sexo</label>
        <div class="control">
          <div class="select">
            <select>
              <option>Masculino</option>
              <option>Feminino</option>
              <option>Outro</option>
            </select>
          </div>
        </div>
      </div>
      <div class="enum-tipo-atendimento">
        <label class="label">Tipo Atendimento</label>
        <div class="control">
          <div class="select">
            <select>
              <option>Convênio</option>
              <option>Particular</option>
            </select>
          </div>
        </div>
      </div>
    </div>

    <div class="field">
      <label class="label">N° Cartão Convênio</label>
      <div class="control">
        <input class="input" type="number" placeholder="n° cartão convênio">
      </div>
    </div>

    <div class="field">
      <label class="label">Data Vencimento</label>
      <div class="control">
        <input class="input" type="date" placeholder="data vencimento">
      </div>
    </div>

    <div class="field">
      <label class="label">Convênio</label>
      <div class="control">
        <input class="input" type="text" placeholder="convênio">
      </div>
    </div>

    <div class="botoes-form">
      <router-link class="link-voltar" to="/paciente">
        <button class="button btn-voltar">Voltar</button>
      </router-link>
      <button class="button btn-editar">Editar</button>
      <button class="button btn-desativar">Desativar</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "FormDetalharPaciente"
}
</script>

<style lang="scss">
@import "~bulma/bulma.sass";
.container{
  margin-left: 30px;
  width: 80%;
}
.titulo{
  display: flex;
  justify-content: center;
  font-size: 30px;
}
.enums{
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  margin-block-end: 20px;
}
.enum-tipo-atendimento{
  margin-left: 40px;
}
.botoes-form{
  display: flex;
  justify-content: space-between;
  flex-direction: row;
  width: 100%;
  margin-top: 20px;
  margin-block-end: 20px;
}
.btn-editar{
  background-color: blue;
  color: white;
  width: 30%;
}
.link-voltar{
  width: 30%;
}
.btn-voltar{
  background-color: dimgrey;
  color: white;
  width: 100%;
}
.btn-desativar{
  background-color: red;
  color: white;
  width: 30%;
}
</style>