package cn.javass.chapter4.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.javass.chapter4.model.EngineModel;
import cn.javass.chapter4.service.EngineService;
//import cn.javass.chapter4.service.UserService;


@Controller
public class EngineManageController  {
	
	private EngineService engineService = new EngineService();
	
	@RequestMapping("/")
    public String index(Model model) {
        //model.addAttribute("list", Lists.newArrayList("a", "b", "c"));
        return "index";
    }

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
    public  ModelAndView updatebypost(HttpServletRequest request,  EngineModel enginemodel){   
        //ModelAndView modelAndView = new ModelAndView();  
        //modelAndView.setViewName("createengine"); 
    	//System.out.println(enginemodel.getEnginename() + " " + enginemodel.getEngineInfo());
    	engineService.update(enginemodel);
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
    
    @RequestMapping(value="/info/{enginename}",  method = {RequestMethod.GET})
    public ModelAndView infobyget(HttpServletRequest request ,@PathVariable(value="enginename") String enginename){   
        ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = engineService.get(enginename);
        //System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        modelAndView.addObject("enginemodel", engine);
        modelAndView.setViewName("infoengine");  
        return modelAndView;
    }
    
    @RequestMapping(value="/delete/{enginename}",  method = {RequestMethod.GET})
    public ModelAndView deletebyget(HttpServletRequest request ,@PathVariable(value="enginename") String enginename){   
        ModelAndView modelAndView = new ModelAndView();  
        EngineModel engine = engineService.get(enginename);
        //System.out.println(engine.getEnginename() + " " + engine.getEngineInfo());
        engineService.delete(engine);
        modelAndView.addObject("engineList", engineService.list());
        modelAndView.setViewName("enginelist");  
        return modelAndView;
    }

}
