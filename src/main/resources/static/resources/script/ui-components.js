/**
 * @author Madusha Mihiranga
 * @version 1.0
 * @description javascript library for create UI component using Semantic UI
 */

/*class UI_Components_Semantic_UI {*/



function createElement(name,id=null){
    const ele = document.createElement(name);
    if(id!=null){
        ele.id = id;
    }
    return ele;
}

/**
 * @description = this function create input field and label.
 * @param type = type of the input field want to create.
 * @param parent  = tag want to append text field
 * @param id = ID of the input field
 * @param labelText = text that appears in the label
 * @param placeholder = text that appear in placeholder
 * @param defaultValue = set default value to the input field
 * @param pattern = regex patter for validate input field
 * @param object =
 * @param property =
 * @param oldObject =
 * @param required =
 * @param validText =
 * @param invalidText
 * @param updateText =
 */

function inputField(type, parent, id, labelText, placeholder, defaultValue, pattern, object, property, oldObject, required, validText, invalidText, updateText) {
    const parentelement = document.getElementById(parent);
    const message = createElement('p', id + "message");
    message.style.fontSize = "12px"
    message.style.marginBottom = "-10px"
    const formGroup = createElement('div', id + 'FormGroup');
    formGroup.classList.add('field');
    formGroup.style.marginTop = "20px";

    const field = createElement('input', id);
    field.type = type;
    field.value = defaultValue;
    field.setAttribute('data-pattern', pattern);
    field.setAttribute('data-object', object);
    field.setAttribute('data-oldobject', oldObject);
    field.style.height = '38px';

    if (labelText !== false) {
        var label = createElement('label', id + 'Label');
        label.for = id;
        // label.classList.add('txtinput-label');
        if (required === true) {
            field.setAttribute('required', true);
            label.innerHTML = labelText + "   <i class=\"fas fa-asterisk\" style='color: #ff6666;font-size: 10px'></i>";
        } else {
            label.innerHTML = labelText;
        }
    }
    field.placeholder = placeholder;
    // field.classList.add('txtinput');
    //field.classList.add('form-control');
    if (labelText !== false) {
        formGroup.appendChild(label);
    }
    formGroup.appendChild(field);
    formGroup.appendChild(message);
    parentelement.appendChild(formGroup);

    if (type === "text" || type === "password"){
        field.onkeyup = function () {
            const object = window[this.getAttribute('data-object')];
            const oldObject = window[this.getAttribute('data-oldobject')];
            const pattern = new RegExp(this.getAttribute('data-pattern'));
            const formGroup = this.parentNode.parentNode;
            if ( validText !== null && invalidText !== null && updateText !== null ){
                formGroup.appendChild(message);
            }
            const val = this.value.trim();
            if (pattern.test(val)) {
                object[property] = val;
                if (oldObject !== null && oldObject[property] !== object[property]) {
                    if (updateText !== null) {
                        message.innerHTML = updateText;
                        message.style.color = '#ffc107';
                    }
                    field.style.border = '1px solid #ffc107';  //update
                    field.style.color = '#ffc107';
                    field.style.boxShadow = 'none';
                } else {
                    if (validText !== null) {
                        message.innerHTML = validText;
                        message.style.color = "#28a745"
                    }
                    field.style.border = '1px solid #28a745';  //valid
                    field.style.color = '#282c2f';
                    field.style.boxShadow = 'none';
                }
            } else {

                if (invalidText !== null) {
                    message.innerHTML = invalidText;
                    message.style.color = "#dc3545"
                }
                field.style.border = '1px solid #dc3545';  //invalid
                field.style.color = '#dc3545';
                field.style.boxShadow = 'none';
                object[property] = null;
            }
        };
    }else if (type === "date" || type === "time"){
        field.onchange = function(){
            var object = window[this.getAttribute('data-object')];
            var oldObject = window[this.getAttribute('data-oldobject')];
            var pattern = new RegExp(this.getAttribute('data-pattern'));
            var formGroup = this.parentNode.parentNode;
            var val = this.value.trim();

            object[property] = val;
            if (oldObject != null && oldObject[property] !== object[property]){
                field.style.border = '1px solid #ffc107';  //update
                field.style.color = '#ffc107';
                field.style.boxShadow = 'none';
            }else{
                field.style.border = '1px solid #28a745';  //valid
                field.style.color = '#282c2f';
                field.style.boxShadow = 'none';
            }
        }
    }
}



/*}

export default UI_Components_Semantic_UI;*/







