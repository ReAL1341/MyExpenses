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

/* ===================
        views
=================== */
import AuthViewComponent from "./components/views/AuthViewComponent.vue"
import HomeViewComponent from "./components/views/HomeViewComponent.vue"


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
    /* ===================
            views
    =================== */
    {
        name: "auth-view-component",
        module: AuthViewComponent,
    },
    {
        name: "home-view-component",
        module: HomeViewComponent,
    }
]


let app = createApp(App)
components.forEach((component) =>
    app.component(component.name, component.module)
)
app.mount("#app")
