import{A as l,B as C,C as _,D as T,E as p,T as R,X as M,Y as P,a as u,d as v,f as I,g as m,h as g,i as y,j as S,l as s,o as d,r as f,s as h,t as F,u as U,v as a,w as c,x as w,y as k,z as D}from"./chunk-MJ3IWQ36.js";var x=(()=>{let t=class t extends P{constructor(){super(...arguments),this.url=""}setUrl(i){this.url=i}getBaseUrl(){return this.url.replace(`${this.getUrlPrefix()}/`,"")}getUrlPrefix(){let i="http://";return i.concat(this.url.replace(i,"").split("/")[0])}getDetailUrl(){return this.get("").pipe(u(i=>i.data),u(i=>i.results[0].urls.filter(n=>n.type==="detail")[0].url))}};t.\u0275fac=(()=>{let i;return function(o){return(i||(i=S(t)))(o||t)}})(),t.\u0275prov=v({token:t,factory:t.\u0275fac,providedIn:"root"});let e=t;return e})();function E(e,t){if(e&1&&(a(0,"span")(1,"p")(2,"strong"),C(3),c()()()),e&2){let r=l(2);s(3),_(r.item.name)}}function B(e,t){if(e&1){let r=k();a(0,"a",0),D("click",function(){g(r);let n=l(2);return y(n.fetchItemDataFromResourceURI())}),a(1,"p")(2,"strong"),C(3),c()()()}if(e&2){let r=l(2);s(3),_(r.item.name)}}function V(e,t){if(e&1&&d(0,E,4,1,"span")(1,B,4,1),e&2){let r=l();h(0,r.isStory()?0:1)}}var j=(()=>{let t=class t{constructor(){this.item=void 0,this.itemService=I(x)}isStory(){return this.item?.hasOwnProperty("type")||!1}fetchItemDataFromResourceURI(){this.itemService.setUrl(this.item?.resourceURI||""),this.itemService.getDetailUrl().subscribe(i=>{window.open(i,"_blank")})}};t.\u0275fac=function(n){return new(n||t)},t.\u0275cmp=m({type:t,selectors:[["item"]],inputs:{item:"item"},standalone:!0,features:[T([x]),p],decls:1,vars:1,consts:[["href","javascript:void(0)",3,"click"]],template:function(n,o){n&1&&d(0,V,2,1),n&2&&h(0,o.item?0:-1)}});let e=t;return e})();var $=(e,t)=>t.resourceURI;function O(e,t){if(e&1&&(a(0,"li"),w(1,"item",2),c()),e&2){let r=t.$implicit;s(),f("item",r)}}var X=(()=>{let t=class t{constructor(){this.title="",this.container=void 0}};t.\u0275fac=function(n){return new(n||t)},t.\u0275cmp=m({type:t,selectors:[["items-container"]],inputs:{title:"title",container:"container"},standalone:!0,features:[p],decls:4,vars:1,consts:[[3,"title"],[1,"items--padding"],[3,"item"]],template:function(n,o){n&1&&(a(0,"panel",0)(1,"ul",1),F(2,O,2,1,"li",null,$),c()()),n&2&&(f("title",o.title),s(2),U(o.container==null?null:o.container.items))},dependencies:[M,R,j],styles:[".items--padding[_ngcontent-%COMP%]{padding-left:1rem}"]});let e=t;return e})();export{X as ItemsContainerComponent};