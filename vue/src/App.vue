<template>
  <AuthFormTemplateComponent
    title="ログイン"
    submitTo="/login"
  />
</template>

<script>
import { defineComponent } from "@vue/composition-api";
import AuthFormTemplateComponent from "./components/templates/AuthFormTemplateComponent.vue";

export default defineComponent({
    setup() {
    },
    components: { AuthFormTemplateComponent }
})
</script>
