public class FoxClub {

//    @Contoller
//    @PostMapping("/login")
//    public String getLoginName(@RequestParam(value = "foxname") String foxname, Model model) {
//        if (foxname != null) {
//            model.addAttribute(foxServiceImpl.findByName(foxname);
//            return "redirect:/index/" + foxname;
//
//        } else {
//            Fox newFox = new Fox(foxname);
//            foxServiceImpl.save(newFox);
//            model.addAttribute("fox", newFox)
//            return "redirect:/index/" + foxname;
//
//--------------------------------------------------------------
//
//    After refactoring
//
//    @Contoller
//    @PostMapping("/login")
//    public String getLoginName(@RequestParam(value = "foxname") String foxname, Model model) {
//        model.addAttribute("fox", foxServiceImpl.login(foxname));
//        return "redirect:/index/" + foxname;
//    }
//
//    @Service
//    public Fox login(String foxname) {
//        if (foxRepository.isExist(foxname)) {
//            return foxRepository.findByName(foxname);
//        } else {
//            Fox newFox = new Fox(foxname);
//            foxRepository.save(newFox);
//            return newFox;
//        }
//    }
}
