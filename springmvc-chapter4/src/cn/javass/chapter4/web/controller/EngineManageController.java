package cn.javass.chapter4.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Lists;

import cn.javass.chapter4.model.EngineModel;
import cn.javass.chapter4.service.EngineDao;
import cn.javass.chapter4.service.EngineService;
//import cn.javass.chapter4.service.UserService;


@Controller
public class EngineManageController  {
	
	private EngineService engineService = new EngineService();
	
	@Autowired
	private EngineDao dao;
	
	public EngineDao getDao() {
		return dao;
	}
	
	public void setDao(EngineDao dao) {  
        this.dao = dao;  
    }  
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/")
    public String index(Model model) {
        //model.addAttribute("list", Lists.newArrayList("a", "b", "c"));
		//List<EngineModel> list = dao.find();
		Collection<EngineModel> col = dao.find();  
        List<EngineModel> list = new ArrayList<EngineModel>();  
        EngineModel engine;  
        for (EngineModel temp : col) {  
            engine = new EngineModel();  
            engine.setEnginename(temp.getEnginename());  
            engine.setEnginestate(temp.getEnginestate());  
            engine.setEngineInfo(temp.getEngineInfo());  
            list.add(temp);  
        }  
		System.out.println(list.size());
		model.addAttribute("list",list);
        return "index";
    }
    
	
	@RequestMapping(value="/create1", method = {RequestMethod.GET})
    public ModelAndView createusemysql(HttpServletRequest request){   
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("enginemodel", new EngineModel());
        modelAndView.setViewName("create");  
        return modelAndView;
    }
    
    @RequestMapping(value="/create1", method = {RequestMethod.POST})
    public  String createbypostusemysql(HttpServletRequest request,Model model,EngineModel enginemodel){   
    	dao.insert(enginemodel);
    	
    	/*Collection<EngineModel> col = dao.find();  
        List<EngineModel> list = new ArrayList<EngineModel>();  
        EngineModel engine;  
        for (EngineModel temp : col) {  
            engine = new EngineModel();  
            engine.setEnginename(temp.getEnginename());  
            engine.setEnginestate(temp.getEnginestate());  
            engine.setEngineInfo(temp.getEngineInfo());  
            list.add(temp);  
        }
    	
    	ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("engineList", list);
        modelAndView.setViewName("index");  */
    	
    	return "redirect:/";
    }
    
    
    
    @RequestMapping(value="/update1/{enginename}",  method = {RequestMethod.GET})
    public ModelAndView updatebygetusemysql(HttpServletRequest request ,@PathVariable(value="enginename") String enginename){   
        ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = dao.select(enginename);
        //System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        modelAndView.addObject("enginemodel", engine);
        modelAndView.setViewName("update");  
        return modelAndView;
    }

    @RequestMapping(value="/update1/{enginename}", method = {RequestMethod.POST})
    public  String updatebypostusemysql(HttpServletRequest request, Model model ,EngineModel enginemodel, @PathVariable(value="enginename") String enginename){   
        
    	enginemodel.setEnginename(enginename);
    	//engineService.update(enginemodel);
    	dao.update(enginemodel);
    	
    	/*Collection<EngineModel> col = dao.find();  
        List<EngineModel> list = new ArrayList<EngineModel>();  
        EngineModel engine;  
        for (EngineModel temp : col) {  
            engine = new EngineModel();  
            engine.setEnginename(temp.getEnginename());  
            engine.setEnginestate(temp.getEnginestate());  
            engine.setEngineInfo(temp.getEngineInfo());  
            list.add(temp);  
        }
    	
    	model.addAttribute("engineList", list);*/
    	
        return "redirect:/";
    }
	
    
    
    @RequestMapping(value="/info1/{enginename}",  method = {RequestMethod.GET})
    public ModelAndView infobygetusemysql(HttpServletRequest request ,@PathVariable(value="enginename") String enginename){   
        ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = dao.select(enginename);
        System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        modelAndView.addObject("enginemodel", engine);
        modelAndView.addObject("thename", engine.getEnginename());
        modelAndView.setViewName("info");  
        return modelAndView;
    }
   
    @RequestMapping(value="/delete1/{enginename}",  method = {RequestMethod.GET})
    public String  deletebygetusemysql(HttpServletRequest request ,Model model,@PathVariable(value="enginename") String enginename){   
        
        //EngineModel engine = dao.select(enginename);
        
        //engineService.delete(engine);
        dao.delete(enginename);
      
        //model.addAttribute("engineList", engineService.list());
        return "redirect:/";
    }
	
	
	/*
	 * 
	 * this part isn't use the mysql
	 * 
	 * 
	 * */
	
	
	
    @RequestMapping(value="/list", method = {RequestMethod.GET})
    public ModelAndView list(){
        
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("engineList", engineService.list());
        modelAndView.setViewName("enginelist");  
        return modelAndView;
    }
    
    @RequestMapping(value="/create", method = {RequestMethod.GET})
    public ModelAndView createbyget(HttpServletRequest request){   
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("enginemodel", new EngineModel());
        modelAndView.setViewName("createengine");  
        return modelAndView;
    }
    
    @RequestMapping(value="/create", method = {RequestMethod.POST})
    public  ModelAndView createbypost(HttpServletRequest request,  EngineModel enginemodel){   
        //ModelAndView modelAndView = new ModelAndView();  
        //modelAndView.setViewName("createengine"); 
    	//System.out.println(enginemodel.getEnginename() + " " + enginemodel.getEngineInfo());
    	engineService.create(enginemodel);
    	//model.addAttribute("engineList", engineService.list());
    	//System.out.println(engineService.list().size());
        //return "enginelist";
    	ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("engineList", engineService.list());
        modelAndView.setViewName("enginelist");  
    	//modelAndView.addObject("enginemodel", enginemodel);
        //modelAndView.setViewName("test");
        return modelAndView;
    }
    
    @RequestMapping(value="/update/{enginename}",  method = {RequestMethod.GET})
    public ModelAndView updatebyget(HttpServletRequest request ,@PathVariable(value="enginename") String enginename){   
        ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = engineService.get(enginename);
        //System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        modelAndView.addObject("enginemodel", engine);
        modelAndView.setViewName("updateengine");  
        return modelAndView;
    }

    @RequestMapping(value="/update/{enginename}", method = {RequestMethod.POST})
    public  String updatebypost(HttpServletRequest request, Model model ,EngineModel enginemodel, @PathVariable(value="enginename") String enginename){   
        //ModelAndView modelAndView = new ModelAndView();  
        //modelAndView.setViewName("createengine"); 
    	//System.out.println(enginemodel.getEnginename() + " " + enginemodel.getEngineInfo());
    	enginemodel.setEnginename(enginename);
    	engineService.update(enginemodel);
    	//model.addAttribute("engineList", engineService.list());
    	//System.out.println(engineService.list().size());
        //return "enginelist";
    	//ModelAndView modelAndView = new ModelAndView();  
        //modelAndView.addObject("engineList", engineService.list());
        //modelAndView.setViewName("enginelist");  
    	model.addAttribute("engineList", engineService.list());
    	//modelAndView.addObject("enginemodel", enginemodel);
        //modelAndView.setViewName("test");
        return "redirect:/list";
    }
    
    
    @RequestMapping(value="/info/{enginename}",  method = {RequestMethod.GET})
    public ModelAndView infobyget(HttpServletRequest request ,@PathVariable(value="enginename") String enginename){   
        ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = engineService.get(enginename);
        //System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        modelAndView.addObject("enginemodel", engine);
        modelAndView.addObject("thename", engine.getEnginename());
        modelAndView.setViewName("infoengine");  
        return modelAndView;
    }
   /* 
    @RequestMapping(value="/delete/{enginename}",  method = {RequestMethod.GET})
    public ModelAndView deletebyget(HttpServletRequest request ,@PathVariable(value="enginename") String enginename){   
        ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = engineService.get(enginename);
        //System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        engineService.delete(engine);
        modelAndView.addObject("engineList", engineService.list());
        modelAndView.setViewName("enginelist");  
        return modelAndView;
    }*/
    @RequestMapping(value="/delete/{enginename}",  method = {RequestMethod.GET})
    public String  deletebyget(HttpServletRequest request ,Model model,@PathVariable(value="enginename") String enginename){   
        //ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = engineService.get(enginename);
        //System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        engineService.delete(engine);
      //  modelAndView.addObject("engineList", engineService.list());
       // modelAndView.setViewName("enginelist");  
        model.addAttribute("engineList", engineService.list());
        return "redirect:/list";
    }

}
