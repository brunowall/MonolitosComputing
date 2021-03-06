package br.com.computingforum.controllers;

import javax.naming.Binding;
import javax.validation.Valid;

import org.hibernate.validator.valuehandling.UnwrapValidatedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import antlr.debug.GuessingEvent;
import br.com.computingforum.dao.AnswerDao;
import br.com.computingforum.dao.QuestionDao;
import br.com.computingforum.dao.UserDao;
import br.com.computingforum.model.Answer;
import br.com.computingforum.model.Question;
import br.com.computingforum.model.User;
import br.com.computingforum.model.category;

@Controller
public class QuestionController {
	@Autowired
	private UserDao userdao;
	@Autowired
	private QuestionDao qdao;
	@Autowired
	private AnswerDao ansdao;
	
	@PostMapping("/private/addquestion")
	public String createQuestion(@ModelAttribute("question") Question question,BindingResult res,@SessionAttribute("user") User user){ //logica de adicao da pergunta
		User u = userdao.getOne(user.getUsername());
		question.setUser(u);
		question.setQid(new Long(0));
		qdao.save(question);
		return "redirect:/";
		
	}
	@GetMapping("/private/fazer-pergunta") //mostra o form de pergunta
	public String show(Model model){
		
		model.addAttribute("question", new Question());
		model.addAttribute("categories", category.values());
		return "add_pergunta";
				
	}
	@GetMapping("/show_all")
	public ModelAndView showAllQuestions(){
		ModelAndView mv  = new ModelAndView();
		mv.addObject("questions", qdao.findAll());
		mv.setViewName("home");
		return mv;
		
	}
	@GetMapping("/show_question")
	public ModelAndView showQuestion(@RequestParam Long id){
		ModelAndView mv =  new ModelAndView();
		mv.addObject("question", qdao.getOne(id));
		mv.addObject("answers", ansdao.getByQuestion(id));
		mv.addObject("answer", new Answer()); //nova answer que pode ser adcionada
		mv.setViewName("view_question");
		return mv;
	}
	
	
	
	
}
