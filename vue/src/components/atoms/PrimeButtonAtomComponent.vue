<template>
  <button
    :class=tagClass
    @click="event"
  >{{ message }}</button>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
    props: {
        message: {
            type: String,
            required: true,
        },
        tagClass: {
            type: String,
            required: false,
        }
    },
    setup(props, { emit }) {
        const event = () => {
            emit("event")
        }

        return {
            event,
        }
    },
})
</script>

<style scoped>
button{
    background-color: #0f83fd;
    border: none;
    border-radius: 1vh;
    color: #ffffff;
    font-size: 2.2vh;
    font-weight: bold;
    padding: 1vh 0;
    text-align: center;
    width: 100%;
}
button:hover{
    background-color: #2179d6;
    cursor: pointer;
}
</style>