(function(){"use strict";var n={345:function(n,e,o){var t=o(9242),r=o(3396);function u(n,e,o,u,i,l){const a=(0,r.up)("auth-template"),s=(0,r.up)("home-template");return(0,r.wg)(),(0,r.iD)(r.HY,null,[(0,r.wy)((0,r.Wm)(a,{onLogin:n.login},null,8,["onLogin"]),[[t.F8,!n.isLoggingIn]]),(0,r.wy)((0,r.Wm)(s,null,null,512),[[t.F8,n.isLoggingIn]])],64)}var i=o(7389),l=(0,i.aZ)({setup(){let n=!1;const e=()=>{n=!0};return{isLoggingIn:n,login:e}}}),a=o(89);const s=(0,a.Z)(l,[["render",u]]);var p=s,m=o(7139);const c=(0,r._)("label",{for:"register"},"新規登録",-1),f=(0,r._)("label",{for:"login"},"ログイン",-1);function d(n,e,o,u,i,l){const a=(0,r.up)("auth-form-component");return(0,r.wg)(),(0,r.iD)(r.HY,null,[(0,r.wy)((0,r._)("input",{type:"radio",name:"form-mode",id:"register",value:"/register","onUpdate:modelValue":e[0]||(e[0]=e=>n.submitTo=e),checked:""},null,512),[[t.G2,n.submitTo]]),c,(0,r.wy)((0,r._)("input",{type:"radio",name:"form-mode",id:"login",value:"/login","onUpdate:modelValue":e[1]||(e[1]=e=>n.submitTo=e)},null,512),[[t.G2,n.submitTo]]),f,(0,r._)("h2",null,(0,m.zw)(n.formTitle),1),(0,r.Wm)(a,{submitTo:n.submitTo},null,8,["submitTo"])],64)}const v=(0,r._)("label",{for:"email"},"メールアドレス",-1),g=(0,r._)("label",{for:"password"},"パスワード",-1);function w(n,e,o,u,i,l){return(0,r.wg)(),(0,r.iD)(r.HY,null,[(0,r._)("div",null,[v,(0,r.wy)((0,r._)("input",{"onUpdate:modelValue":e[0]||(e[0]=e=>n.email=e),type:"email",name:"email",id:"email"},null,512),[[t.nr,n.email]]),(0,r._)("p",null,(0,m.zw)(n.emailErrorMessage),1)]),(0,r._)("div",null,[g,(0,r.wy)((0,r._)("input",{"onUpdate:modelValue":e[1]||(e[1]=e=>n.password=e),type:"password",name:"password",id:"password"},null,512),[[t.nr,n.password]]),(0,r._)("p",null,(0,m.zw)(n.passwordErrorMessage),1)]),(0,r._)("button",{onClick:e[2]||(e[2]=(...e)=>n.submit&&n.submit(...e))})],64)}var b=o(9248),h=o(4870),y=(0,i.aZ)({props:{submitTo:{type:String,required:!0}},setup(n){const e=(0,h.iH)(""),o=(0,h.iH)(""),t=(0,h.iH)(""),r=(0,h.iH)(""),u=()=>{t.value="",r.value="",""==e.value&&(t.value="メールアドレスを入力してください");let u=new FormData;u.append("email",e.value),u.append("password",o.value),b.Z.post(n.submitTo,u).then((n=>{console.log(n)}))};return{email:e,password:o,emailErrorMessage:t,passwordErrorMessage:r,submit:u}}});const _=(0,a.Z)(y,[["render",w]]);var T=_,O=(0,i.aZ)({components:{AuthFormComponent:T},setup(){const n=(0,h.iH)("/register"),e=(0,h.iH)("新規登録");return(0,r.m0)((()=>{"/register"==n.value?e.value="新規登録":e.value="ログイン"})),{submitTo:n,formTitle:e}}});const H=(0,a.Z)(O,[["render",d]]);var Z=H;function k(n,e,o,t,u,i){return(0,r.wg)(),(0,r.iD)("div",null,"home")}var j=(0,i.aZ)({setup(){}});const D=(0,a.Z)(j,[["render",k]]);var E=D;let F=(0,t.ri)(p);F.component("auth-template",Z),F.component("auth-form-component",T),F.component("home-template",E),F.mount("#app")}},e={};function o(t){var r=e[t];if(void 0!==r)return r.exports;var u=e[t]={exports:{}};return n[t](u,u.exports,o),u.exports}o.m=n,function(){var n=[];o.O=function(e,t,r,u){if(!t){var i=1/0;for(p=0;p<n.length;p++){t=n[p][0],r=n[p][1],u=n[p][2];for(var l=!0,a=0;a<t.length;a++)(!1&u||i>=u)&&Object.keys(o.O).every((function(n){return o.O[n](t[a])}))?t.splice(a--,1):(l=!1,u<i&&(i=u));if(l){n.splice(p--,1);var s=r();void 0!==s&&(e=s)}}return e}u=u||0;for(var p=n.length;p>0&&n[p-1][2]>u;p--)n[p]=n[p-1];n[p]=[t,r,u]}}(),function(){o.n=function(n){var e=n&&n.__esModule?function(){return n["default"]}:function(){return n};return o.d(e,{a:e}),e}}(),function(){o.d=function(n,e){for(var t in e)o.o(e,t)&&!o.o(n,t)&&Object.defineProperty(n,t,{enumerable:!0,get:e[t]})}}(),function(){o.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(n){if("object"===typeof window)return window}}()}(),function(){o.o=function(n,e){return Object.prototype.hasOwnProperty.call(n,e)}}(),function(){var n={143:0};o.O.j=function(e){return 0===n[e]};var e=function(e,t){var r,u,i=t[0],l=t[1],a=t[2],s=0;if(i.some((function(e){return 0!==n[e]}))){for(r in l)o.o(l,r)&&(o.m[r]=l[r]);if(a)var p=a(o)}for(e&&e(t);s<i.length;s++)u=i[s],o.o(n,u)&&n[u]&&n[u][0](),n[u]=0;return o.O(p)},t=self["webpackChunkvue"]=self["webpackChunkvue"]||[];t.forEach(e.bind(null,0)),t.push=e.bind(null,t.push.bind(t))}();var t=o.O(void 0,[998],(function(){return o(345)}));t=o.O(t)})();
//# sourceMappingURL=app.a7474474.js.map