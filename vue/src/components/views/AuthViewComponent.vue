<template>
  <div class="auth-background">
    <auth-form-template-component
      title="新規登録"
      submitTo="/register"
      @login="login"
    />
    <auth-form-template-component
      title="ログイン"
      submitTo="/login"
      @login="login"
    />
  </div>
</template>

<script>
import { defineComponent } from "@vue/composition-api";

export default defineComponent({
  setup(props, { emit }) {
    const login = (userId) => {
      emit("login", userId)
    }

    return {
      login,
    }
  },
})
</script>

<style scoped>
.auth-background{
  background-color: #c7c4c4;
  height: 100%;
  position: fixed;
  width: 100%;
}
</style>