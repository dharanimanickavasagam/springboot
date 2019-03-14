package com.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.StatusUpdate;
import com.springboot.service.StatusUpdateService;

@Controller
public class StatusUpdateController {

	@Autowired
	private StatusUpdateService statusUpdateService;

	@RequestMapping(value = "/addstatus", method = RequestMethod.GET)
	public String status(Model model,
			@ModelAttribute("statusUpdate") StatusUpdate statusUpdate) {

		// ////////////////////////////////////////////////////////////////////////
		//
		// Why create a new StatusUpdate() object ?
		// The form on the page will add the date ultimately to it
		//
		// StatusUpdate is the return type of getlatest()
		// model.addAttribute("latest", latest); -> "latest" can be any name
		// It is used in the .jsp to retrieve the StatusUpdate Object
		//

		// @ModelAttribute is used to define ModelAttribute
		// so there is no need to create a constructor to StatusUpdate
		// model.addAttribute("statusUpdate", new StatusUpdate());
		// also the model attribute should match will the modelAttribute of
		// addStatus.jsp

		StatusUpdate latest = statusUpdateService.getlatest();
		model.addAttribute("latest", latest);

		return "addStatus";
	}

	//
	// StatusUpdate is returned by the form
	// So add StatusUpdate to POST
	//
	// @Valid
	// The object will be validated according to the validations mentioned in
	// the annotated class and the result will be put up in BindingResult
	//

	@RequestMapping(value = "/addstatus", method = RequestMethod.POST)
	public ModelAndView status(ModelAndView mv,
			@Valid StatusUpdate statusUpdate, BindingResult result) {

		mv.setViewName("addStatus");
		if (!result.hasErrors()) {

			statusUpdateService.save(statusUpdate);

			// Clears the form content
			mv.getModel().put("statusUpdate", new StatusUpdate());
			mv.setViewName("redirect:/viewstatus");

		}

		StatusUpdate latest = statusUpdateService.getlatest();
		mv.getModel().put("latest", latest);

		return mv;

	}

	//
	// Retrieves pages wrt pagenumbers
	// @RequestParam - supply a default value for the param p

	@RequestMapping(value = "/viewstatus", method = RequestMethod.GET)
	ModelAndView viewStatus(ModelAndView mv,
			@RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {

		/*
		 * System.out.println(); System.out.println(" ===============" +
		 * pageNumber + "==============="); System.out.println();
		 */

		Page<StatusUpdate> page = statusUpdateService.getPage(pageNumber);

		mv.setViewName("viewStatus");
		mv.getModel().put("page", page);
		return mv;
	}

	@RequestMapping(value = "/deletestatus", method = RequestMethod.GET)
	public ModelAndView deleteStatus(ModelAndView mv,
			@RequestParam(name = "id") Long id) {
		mv.setViewName("deleteStatus");

		StatusUpdate statusUpdate = statusUpdateService.getByID(id);
		mv.getModel().put("statusUpdate", statusUpdate);
		statusUpdateService.deleteStatus(id);

		// comment me to see Dharani's code
		mv.setViewName("redirect:/viewstatus");

		return mv;
	}

	@RequestMapping(value = "/editstatus", method = RequestMethod.GET)
	public ModelAndView editStatus(ModelAndView mv,
			@RequestParam(name = "id") Long id) {

		StatusUpdate statusUpdate = statusUpdateService.getByID(id);
		mv.setViewName("editStatus");
		mv.getModel().put("statusUpdate", statusUpdate);

		return mv;
	}

	@RequestMapping(value = "/editstatus", method = RequestMethod.POST)
	public ModelAndView editStatus(ModelAndView mv,
			@RequestParam(name = "id") Long id,
			@Valid StatusUpdate statusUpdate, BindingResult result) {
		mv.setViewName("editStatus");
		if (!result.hasErrors()) {
			statusUpdateService.save(statusUpdate);
			mv.setViewName("redirect:/viewstatus");
		}
		mv.getModel().put("statusUpdate", statusUpdate);

		return mv;
	}
}
