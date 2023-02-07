<template>
  <div
    v-if="messages.length > 0"
    :class=tagClass
  >
    <img src="/assets/error-icon.svg">
    <ul>
      <li
        v-for="message in messages"
        :key="message"
      >{{ message }}</li>
    </ul>
  </div>
</template>

<script>
import { defineComponent } from '@vue/composition-api'

export default defineComponent({
    props: {
        messages: {
            type: Array,
            required: false,
        },
        tagClass: {
            type: String,
            required: false,
        }
    }
})
</script>

<style scoped>
div{
    background-color: #ffDDDD;
    display: flex;
    font-size: 2vh;
    padding: 1vh 1vh;
}
img{
    height: 5vh;
    width: auto;
}
ul{
    color: #ff0000;
    margin: 0;
}
</style>