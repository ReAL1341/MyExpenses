<template>
  <auth-view-component
    v-if="!isLoggingIn"
    @login="login"
  />
  <home-view-component
    v-if="isLoggingIn"
  />
</template>

<script>
import { defineComponent } from "@vue/composition-api";
import { onMounted, ref } from "vue"
import axios from "axios";

export default defineComponent({
    setup() {
      const isLoggingIn = ref(false)
      const login = (userId) => {
        if(userId != null) {
          isLoggingIn.value = true
        }
      }

      onMounted(() => {
        axios.get("/login").then(res => {
          login(res.data.userId)
        })
      })

      return {
        isLoggingIn,
        login,
      }
    },
})
</script>
