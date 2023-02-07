/* ===================
        app
=================== */
import { createApp } from "vue"
import App from "./App.vue"

/* ===================
        atoms
=================== */
import InputAtomComponent from "./components/atoms/InputAtomComponent.vue"
import PrimeButtonAtomComponent from "./components/atoms/PrimeButtonAtomComponent.vue"
import ErrorMessageAtomComponent from "./components/atoms/ErrorMessageAtomComponent.vue"

/* ===================
        templates
=================== */
import AuthFormTemplateComponent from "./components/templates/AuthFormTemplateComponent.vue"



import HomeTemplate from "./components/home/HomeTemplate.vue"

const components = [
    /* ===================
            atoms
    =================== */
    {
        name: "input-atom-component",
        module: InputAtomComponent,
    },
    {
        name: "prime-button-atom-component",
        module: PrimeButtonAtomComponent,
    },
    {
        name: "error-message-atom-component",
        module: ErrorMessageAtomComponent,
    },
    /* ===================
            templates
    =================== */
    {
        name: "auth-form-template-component",
        module: AuthFormTemplateComponent,
    },

    {
        name: "home-template",
        module: HomeTemplate,
    }
]


let app = createApp(App)
components.forEach((component) =>
    app.component(component.name, component.module)
)
app.mount("#app")
