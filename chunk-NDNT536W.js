import{a as n}from"./chunk-Y73ZGC6L.js";import"./chunk-D4BRUKWR.js";import{D as h,E as f,F as v,G as b,L as g,T as C,W as D,X as S,g as s,l as a,m as l,n as m,r as o,v as p,w as d,x as u}from"./chunk-MJ3IWQ36.js";var F=()=>({icon:"clock.svg",to:"/character-event-list"}),w=i=>[i],x=(()=>{let t=class t{constructor(e){this.charactersService=e,this.columnDefinitions=[],this.characters=m(void 0)}ngOnInit(){this.columnDefinitions=[{attr:"image",imgSrc:e=>this.buildThumbnailPath(e.thumbnail)},{attr:"name",label:"Name",target:e=>`/character/${e.id}`},{attr:"description",label:"Description"}],this.charactersService.getAll().subscribe(e=>{this.characters.set(e?.data?.results)})}buildThumbnailPath(e){return e?`${e.path}/standard_small.${e.extension}`:""}};t.\u0275fac=function(r){return new(r||t)(l(n))},t.\u0275cmp=s({type:t,selectors:[["character-list"]],standalone:!0,features:[h([n]),f],decls:4,vars:6,consts:[[1,"row"],[1,"col"],["title","List of Characters",3,"actions"],[3,"columnDefinitions","rowObjects"]],template:function(r,c){r&1&&(p(0,"div",0)(1,"div",1)(2,"panel",2),u(3,"custom-table",3),d()()()),r&2&&(a(2),o("actions",b(4,w,v(3,F))),a(),o("columnDefinitions",c.columnDefinitions)("rowObjects",c.characters()))},dependencies:[S,C,D,g]});let i=t;return i})();export{x as CharacterListComponent};
