<template>
  <input
    v-model="value"
    :type = type
    :name = name
    :placeholder = placeholder
    :class = tagClass
    @input="updateValue"
  />
</template>

<script>
import { defineComponent } from "@vue/composition-api";
import { ref } from "vue"

export default defineComponent({
    props: {
        type: {
            type: String,
            required: true,
        },
        name: {
            type: String,
            required: true,
        },
        placeholder: {
            type: String,
            required: false,
        },
        tagClass: {
            type: String,
            required: false,
        }
    },
    setup(props, { emit }) {
        const value = ref("")

        const updateValue = () => {
            emit("update-value", value.value)
        }

        return {
            value,
            updateValue,
        }
    },
})
</script>

<style scoped>
input{
    border: none;
    border-bottom: solid 3px #cdcaca;
    box-sizing: border-box;
    display: block;
    font-size: 2.2vh;
    outline: none;
    padding: 0.6vh 1.4vh 0.4vh;
    width: 100%;
}
input:focus{
    border-bottom: solid 3px #FF3F3F;
}
</style>