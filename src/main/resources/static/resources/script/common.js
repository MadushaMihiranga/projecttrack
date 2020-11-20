/**
 * @author Madusha Mihiranga
 * @version 1.0
 * @description
 */

function httpRequest(url,method,data){

    var ajax = new XMLHttpRequest();
    ajax.open(method, url, false);
    ajax.setRequestHeader("Content-type", "application/json");
    // startWaiting("Plase Wait");
    ajax.send(JSON.stringify(data, getCircularReplacer()));
    //  stopWaiting();


    // logError("AJAX Responce", url, ajax.responseText+"---"+ajax.status);

    if (ajax.status == 200) {
        if(method=="GET"&&ajax.responseText!="")
            return JSON.parse(ajax.responseText);
        else return ajax.responseText;
    }
    else if (ajax.status == 400 || ajax.status == 500 )
    {
        if(JSON.parse(ajax.responseText).errors!=undefined)
            return JSON.parse(ajax.responseText).errors[0].defaultMessage;
        else
            return JSON.parse(ajax.responseText).message;

    }
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
        alert("Welcome again " + user);
    } else {
        user = prompt("Please enter your name:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}


function isArrayLike(item) {
    return (
        Array.isArray(item) ||
        (!!item &&
            typeof item === "object" &&
            item.hasOwnProperty("length") &&
            typeof item.length === "number" &&
            item.length > 0 &&
            (item.length - 1) in item
        )
    );
}

function replaceClassElementArray(elements, newClass, oldClass) {
    if (Array.isArray(elements) || !isArrayLike(elements)){
        for (let element of elements){
            element.classList.contains(oldClass) ? element.classList.replace(oldClass,newClass) : element.classList.add(newClass);
        }
    }
}

function replaceClassElement(element, newClass, oldClass) {
    element.classList.contains(oldClass) ? element.classList.replace(oldClass,newClass) : element.classList.add(newClass);
}

function addClass(elements,className) {
    if (Array.isArray(elements) || !isArrayLike(elements)){
        for (let element of elements){
            element.classList.add(className)
        }
    } else {
        elements.classList.add(className)
    }
}


function createLoader(id,text,parentElement) {
    text = (typeof text !== 'undefined') ?  text : "Loading";
    parentElement = (typeof parentElement !== 'undefined') ?  parentElement : document.getElementsByTagName('body')[0];
    parentElement.appendChild(createDOMElement('div',['ui','disabled','page','dimmer'],null,null,id))
        .appendChild(createDOMElement('div',['ui','text','loader','disabled'],null,text,null));
}

function toggleLoader(id) {
    let dimmer = document.getElementById(id);
    let loader = dimmer.firstChild;
    dimmer.classList.contains('active') ? dimmer.classList.replace('active','disabled') :  dimmer.classList.replace('disabled','active');
    loader.classList.contains('active') ? loader.classList.replace('active','disabled') :  loader.classList.replace('disabled','active');
}






function createDOMElement(tag,cssClasses,attributes,innerHTML,id,style) {
    cssClasses = (typeof cssClasses !== 'undefined') ?  cssClasses : null;
    id = (typeof id !== 'undefined') ?  id : null;
    attributes = (typeof attributes !== 'undefined') ?  attributes : null;
    style = (typeof style !== 'undefined') ?  style : null;
    innerHTML = (typeof innerHTML !== 'undefined') ?  innerHTML : null;
    let element = document.createElement(tag);

    if (cssClasses !== null){
        for (let cssClass of cssClasses){
            element.classList.add(cssClass);
        }
    }
    if (attributes !== null){
        for (let attribute of attributes){
            element.setAttribute(attribute.name,attribute.value);
        }
    }
    if (innerHTML !== null){
        element.innerHTML = innerHTML;
    }
    if (style !== null){
        element.style.cssText = style
    }
    if (id !== null){
        element.id = id;
    }
    return element;
}

function decompress(string) {
    return LZString.decompressFromUTF16(string);
}

function compress(string) {
    return  LZString.compressToUTF16 (string);
}