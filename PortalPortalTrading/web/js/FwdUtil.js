/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
get = function(sid){return document.getElementById(sid);};

var mask = new Array();
var countMask = 0;
var hashLoad = new Array();

//Ice.modal.start2 = Ice.modal.start;
//Ice.modal.start = function(F,C,B,H){try{loadMask(F);onOpenPopUp(F);}catch(e){}return Ice.modal.start2(F,C,B,H);}
//
//Ajax.PeriodicalUpdater.start2 = Ajax.PeriodicalUpdater.start;
//Ajax.PeriodicalUpdater.start = function(){alert("Ajax.PeriodicalUpdater.start");return Ajax.PeriodicalUpdater.start2()}
//
//Draggable.startDrag2 = Draggable.startDrag;
//Draggable.startDrag = function(B){alert("Draggable.startDrag");return Draggable.startDrag2(B)};
//
//SortableObserver.onStart2 = SortableObserver.onStart;
//SortableObserver.onStart = function(){alert("SortableObserver.onStart");return SortableObserver.onStart2();};
//
//Control.Slider.startDrag2 = Control.Slider.startDrag;
//Control.Slider.startDrag = function(C){alert("Control.Slider.startDrag");return Control.Slider.startDrag2(C);};
//
//Ice.autoCentre.start2 = Ice.autoCentre.start;
//Ice.autoCentre.start = function(A){alert("Ice.autoCentre.start");return Ice.autoCentre.start2(A);};
//
//Ice.autoPosition.start2 = Ice.autoPosition.start;
//Ice.autoPosition.start = function(C,A,D){alert("Ice.autoPosition.start");return Ice.autoPosition.start2(C,A,D);};
monitIce = function(){
    if (!Ice.iFrameFix.start2)
    {
        Ice.iFrameFix.start2 = Ice.iFrameFix.start;
        Ice.iFrameFix.start = function(B, D){try{loadMask(B);}catch(e){}return Ice.iFrameFix.start2(B,D);};
    }
    setTimeout('loadMask("")',100);
}
removeMonitIce = function()
{
    if (Ice.iFrameFix.start2)
    {
        Ice.iFrameFix.start = Ice.iFrameFix.start2;
        Ice.iFrameFix.start2 = null;
    }
}
//Ice.SortEvent.start2 = Ice.SortEvent.start;
//Ice.SortEvent.start = function(){alert("Ice.SortEvent.start"); return Ice.SortEvent.start2();};

loadMask = function(sidmodal)
{
    for(i in mask)
    {
        if (typeof(mask[i].id) == "string")
            field = get(mask[i].id);
        else
            field = mask[i].relative;
        if(field && !field.maskOK)
        {
            field.settings = new Object();
            if(mask[i].nextField)
                field.settings.nextField = get(mask[i].nextField)
            //alert("field.name = " + field.name);
            maskSet = false;
            if (mask[i].mask) //NORMAL MASK
            {
                //alert("INICIO - NORMAL MASK - mask[i].id = " + mask[i].id + " - mask[i].mask = " + mask[i].mask);
                setMask(mask[i].id, mask[i].mask);
                maskSet = true;

                field.maskOK = maskSet;
                //alert("FIM - NORMAL MASK - mask[i].id = " + mask[i].id + " - mask[i].mask = " + mask[i].mask);
            }
            else //CONDITION
            {
                //alert("INICIO - CONDITION MASK - mask[i].id = " + mask[i].id + " - mask[i].mask = " + mask[i].mask);
                if (typeof(mask[i].relative) == "string")
                    fieldRel = get(mask[i].relative);
                else
                    fieldRel = mask[i].relative;
                if(fieldRel)
                {
                    //alert("fieldRel.getAttribute('style') = " + fieldRel.getAttribute("style",2));
                    //alert("field.rel.name = " + fieldRel.name);
                    if(getAttributeStyle(fieldRel, "display") != "none")
                    {
                        //alert("INICIO - STYLE");
                        conditions = mask[i].condition.split(",");
                        for(j = 0; j < conditions.length; j++)
                        {
                            //alert("FOR j = " + j);
                            valueCondMask = conditions[j].split("|")
                            if(valueCondMask.length == 2)
                            {
                                if(fieldRel.value == valueCondMask[0])
                                {
                                    setMask(mask[i].id, valueCondMask[1]);
                                    //alert("mask[i].id = " + mask[i].id + " - valueCondMask[1] = " + valueCondMask[1]);
                                    maskSet = true;
                                    break;
                                }
                            }
                        }
                        //alert("FIM - STYLE");
                    }
                    if (!maskSet && mask[i].maskDefault)
                    {
                        setMask(mask[i].id, mask[i].maskDefault);
                        //alert("mask[i].id = " + mask[i].id + " - mask[i].maskDefault = " + mask[i].maskDefault);
                        maskSet = true;
                    }

                    if(!fieldRel.changMask)
                    {
//                        var f = fieldRel.onchange;
//                        fieldRel.onchange = function(){if(f)f();loadMask();};
                        observeEvent(fieldRel,"change",loadMask)
                        fieldRel.changMask = "true";
                    }
                }
                if(!field.focusMask)
                {
//                    var s = field.onfocus;
//                    field.onfocus = function(){if(s)s();loadMask()};
                    observeEvent(field,"focus",loadMask)
                    field.focusMask = "true";
                }
                //alert("FIM - CONDITION MASK - mask[i].id = " + mask[i].id + " - mask[i].mask = " + mask[i].mask);
            }
        }
    }
}
getAttributeStyle = function(obj, sattibute)
{
    objStyle = obj.getAttribute("style");
    if(typeof(objStyle) == "object")
    {
        try{return objStyle[sattibute]}catch(e){}
    }
    else if(typeof(objStyle) == "string")
    {
        try{return obj.style[sattibute]}catch(e){}
    }
    return null;
}

fieldMask = function(sid, smask, nextField)
{
    if(typeof(sid) == "string")
        idHash = sid;
    else
        idHash = sid.id
    if (smask)
    {
        smask = smask.substr(0,1).toUpperCase()+ smask.substr(1);
        mask[idHash] = {id:sid, mask:smask, relative:null, condition:null, maskDefault:null, idMask:"mask"+countMask, nextField: nextField};
        countMask++;
    }
    else alert("Mascara invalida!! id(" + sid + ")")
}
//id campo   ,  mascara ou tipo, id campo referente as condicoes, [valorcondicao|mascara,valorcondicao|mascara]
fieldMaskCondition = function(sid, relat, scondition, smaskDefault)
{
    if(typeof(sid) == "string")
        idHash = sid;
    else
        idHash = sid.id
    if (relat == undefined) relat = null
    if (scondition == undefined) scondition = null
    if (smaskDefault == undefined) smaskDefault = null
    else if (typeof(smaskDefault) == "string") smaskDefault = smaskDefault.substr(0,1).toUpperCase()+ smaskDefault.substr(1);

    mask[idHash] = {id:sid, mask:null, relative:relat, condition:scondition, maskDefault:smaskDefault, idMask:"mask"+countMask};
    countMask++;
}

onOpenPopUp = function(sidPop){}
