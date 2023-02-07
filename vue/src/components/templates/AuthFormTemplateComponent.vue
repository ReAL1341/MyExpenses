<template>
  <div class="form-background">
    <h1>{{ title }}</h1>

    <input-atom-component
      type="email"
      name="email"
      placeholder="メールアドレス"
      class="form-input"
      @update-value="updateEmail"
    />

    <input-atom-component
      type="password"
      name="password"
      placeholder="パスワード"
      class="form-input"
      @update-value="updatePassword"
    />
    <error-message-atom-component
      :messages=errorMessages
      class="error-message"
    />

    <prime-button-atom-component
      message="送信"
      class="submit-button"
      @event="submit"
    />

  </div>
</template>

<script>
import { defineComponent } from "@vue/composition-api"
import { ref } from "vue"
import axios from 'axios'

export default defineComponent({
  props: {
    title: {
      type: String,
      required: true,
    },
    submitTo: {
      type: String,
      required: true,
    },
  },
  setup(props) {
    const email = ref("")
    const password = ref("")
    const updateEmail = (newEmail) => {
      email.value = newEmail
    }
    const updatePassword = (newPassword) => {
      password.value = newPassword
    }

    const errorMessages = ref([])
    const submit = () => {
      axios.post(props.submitTo, {
        email: email.value,
        password: password.value,
      }).then(res => {
        if("messages" in res.data){
          errorMessages.value = res.data.messages
        }else {
          // 成功したときの処理
          console.log('ok')
        }
      })
    }

    return {
      email,
      password,
      updateEmail,
      updatePassword,
      errorMessages,
      submit,
    }
},
})
</script>

<style scoped>
.form-background{
  background-color: #ffffff;
  box-sizing: border-box;
  margin: auto;
  padding: 3vh 2.2vh 5vh;
  width: 44vh;
}
h1{
  margin-bottom: 6vh;
  text-align: center;
}
.form-input{
  margin: 0 auto 1vh;
}
.error-message{
  margin-bottom: 4vh;
}
.submit-button{
  margin-top: 2vh;
}
p{
  text-align: center;
}
span{
  color: #0000ff;
  text-decoration: underline;
}
span:hover{
  color: #ff0000;
  cursor: pointer;
}
</style>