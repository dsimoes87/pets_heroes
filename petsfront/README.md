# angular

nvm install v10.15.3
npm install -g typescript
npm install -g @angular/cli
ng new project-name
cd project-name
ng serve
ng g m nome-modulo "create new module"
ng g c nome-componente "create new compent"

into declarations in ngmodule we put components of module, directives and pipes.
into imports in ngmodule we put other used modules.
in providers of appmodule we put services that are available throughout the application

when creating a new component we need to declare it in your module and put the component in exports section.

you need to declare any new module in imports section of appmodule.

to create a new component into directory existing we use
ng g c directory/component-name

some components may only be visible in your module if it isn't exported.

to create a service we use
ng g s component-name/service-name
add the service to providers in module
import the class service in component
pass the class service as parameter to component constructor
use the service methods

interpolation : {{valor}}
property binding: [property]="value" or (event) = "handler"
to way data binding : [(ngModel)]="property" //precisa ter o FormsModule em todo modulo que utilizar a diretiva.

Class and Style binding:
npm install bootstrap --save
npm install ngx-bootstrap --save
npm install jquery

Para usar uma variavel de um componente em outro é necessário fazer o input da variavel que vai receber o valor.