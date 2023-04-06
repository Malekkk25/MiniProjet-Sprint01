package com.malek.vols.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import com.malek.vols.entities.Vol;
import com.malek.vols.service.VolService;

@Controller
public class VolController {
@Autowired
VolService volService;

@RequestMapping("/showCreate")
public String showCreate() {
	return "createVol";
}
@RequestMapping("/saveVol")
public String saveVol(@ModelAttribute("vol") Vol vol, 
 @RequestParam("date") String date,ModelMap modelMap) throws
ParseException 
{
 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateDepart = dateformat.parse(String.valueOf(date));
 vol.setDateDepart(dateDepart);
 
Vol saveVol = volService.saveVol(vol);
String msg ="vool enregistré avec Id "+saveVol.getIdVol();
modelMap.addAttribute("msg", msg);
return "createVol";
}

@RequestMapping("/ListeVols")
public String listeVols(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Vol> vo = volService.getAllVolsParPage(page, size);
modelMap.addAttribute("vols", vo);
 modelMap.addAttribute("pages", new int[vo.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeVols";
}
@RequestMapping("/supprimerVol")
public String supprimerVol(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
{
volService.deleteVolById(id);
Page<Vol> vo = volService.getAllVolsParPage(page, 
size);
modelMap.addAttribute("vols", vo);
modelMap.addAttribute("pages", new int[vo.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeVols";
}
@RequestMapping("/modifierVol")
public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
{
Vol v= volService.getVol(id);
modelMap.addAttribute("vol", v);
return "editerVols";
}
@RequestMapping("/updateVol")
public String updateVol(@ModelAttribute("vol") Vol vol,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException 
{
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateDepart = dateformat.parse(String.valueOf(date));
 vol.setDateDepart(dateDepart);
 
 volService.updateVol(vol);
 List<Vol> vo = volService.getAllVols();
 modelMap.addAttribute("vols", vo);
return "listeVols";
}

}
	

