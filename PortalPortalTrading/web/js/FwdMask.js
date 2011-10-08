/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function Mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}

/*Função que Executa os objetos*/
function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}



/*Função que permite apenas numeros com virgula*/
// exemplo
//<ice:inputText onkeydown="Mascara(this,Integer);" onkeypress="Mascara(this,Integer);" onkeyup="Mascara(this,Integer);" />
function Integer(v){
    v=v.replace(/[^0-9,]/g,"");//permite so numeros de 0 a 9 e virgula
    v=v.replace(/^(,)/g,"");//caso o primeiro caracter seja uma virgula remove-a
    v=v.replace(/([^0-9])+(,{2,})/g,"$1,");//caso use ,, retorna o primeiro parametro
    v=v.replace(/(,\d*)+(,)/g,"$1");//se vir virgula depois numero depois virgula retorna o primeiro parametro
    return v;
}

function IntegerDigitos(v){
    v=v.replace(/[^0-9]/g,"");
    v=v.replace(/^0+(\d{1})/g,"$1");
    return v;
}

function DecimalDigitos(v){
    v=v.replace(/[^0-9,]/g,"");
    v=v.replace(/^(,)/g,"0,");
    v=v.replace(/([^0-9])+(,{1,})/g,"$1");
    v=v.replace(/(,\d*)+(,)/g,"$1");
    v=v.replace(/^0+(\d{1})/g,"$1");
    return v;
}

function MaskEB(oObj, fFunc, sPers) {
    fFunc = fFunc.substr(0,1).toUpperCase()+ fFunc.substr(1);
    f_oObj = oObj;
    f_Func = fFunc;
    f_Pers = sPers;
    setTimeout("execMask()",1)
}

function execMask() {
    if ((f_Func != "") && (f_Func != "NULL")) {
        eval("Mask" + f_Func + "('" + f_oObj.name +"')");
    } else if (f_Pers != "") {
        new InputMask(f_Pers, f_oObj.name);
    }
}

function MaskData(nameObj) {
    var dateParser1 = new DateParser("dd/MM/yyyy");
    var dateMask1 = new DateMask(dateParser1, nameObj);
    var errorMessage = "Data inválida: ${value}. Formato requerido: ${mask}";
    dateMask1.validationMessage = errorMessage;
}

function MaskCpf(nameObj) {
    new InputMask("###.###.###-##", nameObj);
}

function MaskCep(nameObj) {
    new InputMask("#####-###", nameObj);
}

function MaskCnpj(nameObj) {
    new InputMask("##.###.###/####-##", nameObj);
}

function MaskTelefone(nameObj) {
    new InputMask("(##) ####-####", nameObj);
}

function MaskNoMask(nameObj) {
    new InputMask("noMask", nameObj);
}

function MaskMoeda(nameObj) {
    var decimalSeparator = ",";
    var groupSeparator = ".";

    var numParser = new NumberParser(2, decimalSeparator, groupSeparator, true);
    numParser.currencySymbol = "";
    numParser.useCurrency = true;
    numParser.negativeParenthesis = true;
    numParser.currencyInside = true;
    new NumberMask(numParser, nameObj, 10);
}

function MaskInteger(nameObj) {
    var decimalSeparator = ",";
    var groupSeparator = ".";

    var numParser = new NumberParser(0, decimalSeparator, groupSeparator, true);
    numParser.currencySymbol = "";
    numParser.useCurrency = true;
    numParser.negativeParenthesis = true;
    numParser.currencyInside = true;
    new NumberMask(numParser, nameObj, 10);
}

function MaskIntegerDigitos(nameObj) {
    var numParser = new NumberParser(0, "", "", false);
    new NumberMask(numParser, nameObj, 10);
}

function MaskId(nameObj) {
    new InputMask("##########", nameObj);
}
function MaskDecimal(nameObj, sIntDec) {
    var decimalSeparator = ",";
    var aIntDec = null;
    if (sIntDec != undefined)
        aIntDec = sIntDec.split(",")

    var numParser = new NumberParser(0, decimalSeparator, null, false);

    numParser.currencySymbol = "";
    numParser.useCurrency = true;
    numParser.negativeParenthesis = true;
    numParser.currencyInside = true;
    beforeSeparator = 10;
    afterSeparator = 2;
    if (aIntDec != null)
    {
        beforeSeparator = parseInt(aIntDec[0],10);
        if(aIntDec.length > 1)
            afterSeparator = parseInt(aIntDec[1],10);
    }
    numParser.decimalDigits = afterSeparator;
    new NumberMask(numParser, nameObj, beforeSeparator);
}

//function MaskDecimalDigitos(nameObj) {
//    var numParser = new NumberParser(0, ",", "", false);
//    numParser.decimalDigits = 10;
//    new NumberMask(numParser, nameObj, 10);
//}

function RemoveMask(obj) {
    while(obj.aListeners.length)
    {
        iLen = obj.aListeners.length - 1;
        //        eval("obj.on" + obj.aListeners[iLen].sEvent + " = new function(){};");
        //obj.removeEventListener(obj.aListeners[iLen].sEvent,obj.aListeners[iLen].oListener);
        //object.addEventListener(eventName,function(e){return invokeAsMethod(object,handler,[e])},false)
        //obj.removeEventListener(obj.aListeners[iLen].sEvent,obj.aListeners[iLen].oListener,true);
        //obj["on"+obj.aListeners[iLen].sEvent]= function(){};
        //obj.dispatchEvent('on'+obj.aListeners[iLen].sEvent)
        removeEvent(obj,obj.aListeners[iLen].sEvent,obj.aListeners[iLen].handler)

        obj.aListeners.pop();
    }
    obj.removeEventListener("keydown",obj.mask.onKeyDown,false)
    obj.removeEventListener("keypress",obj.mask.onKeyPress,false)
    obj.removeEventListener("keyup",obj.mask.onKeyUp,false)
    obj.removeEventListener("focus",obj.mask.onFocus,false)
    obj.removeEventListener("blur",obj.mask.onBlur,false)

    obj.removeEventListener("onkeydown",obj.mask.onKeyDown,false)
    obj.removeEventListener("onkeypress",obj.mask.onKeyPress,false)
    obj.removeEventListener("onkeyup",obj.mask.onKeyUp,false)
    obj.removeEventListener("onfocus",obj.mask.onFocus,false)
    obj.removeEventListener("onblur",obj.mask.onBlur,false)

    obj.removeEventListener("keydown",obj.mask.onKeyDown,true)
    obj.removeEventListener("keypress",obj.mask.onKeyPress,true)
    obj.removeEventListener("keyup",obj.mask.onKeyUp,true)
    obj.removeEventListener("focus",obj.mask.onFocus,true)
    obj.removeEventListener("blur",obj.mask.onBlur,true)

    obj.removeEventListener("onkeydown",obj.mask.onKeyDown,true)
    obj.removeEventListener("onkeypress",obj.mask.onKeyPress,true)
    obj.removeEventListener("onkeyup",obj.mask.onKeyUp,true)
    obj.removeEventListener("onfocus",obj.mask.onFocus,true)
    obj.removeEventListener("onblur",obj.mask.onBlur,true)
}
function removeEvent(object,eventName,handler){
    object=getObject(object);
    if(object!=null){
        if(object.removeEventListener){
            object.removeEventListener(eventName,handler,true)
            object.removeEventListener("on"+eventName,handler,true)
            object.removeEventListener(eventName,handler,false)
            object.removeEventListener("on"+eventName,handler,false)

        } else if(object.attachEvent){
            object.attachEvent("on"+eventName,function(){
                return invokeAsMethod(object,handler,[window.event])
            })
        } else {
            object["on"+eventName]=handler
        }
    }
}
setMask = function(fieldId, mask, descAdd)
{
    if (typeof(mask) == "string") mask = mask.substr(0,1).toUpperCase()+ mask.substr(1);
    try{
        func = eval("Mask" + mask);
        if (!descAdd)
            func(fieldId);
        else
            func(fieldId,descAdd)
    }catch(e)
    {
        new InputMask(mask, fieldId);
    }
}