package ggc.app.partners;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.exception.UnknownKeyException;
import ggc.app.exception.UnknownPartnerKeyException;
import ggc.core.Partner;
import ggc.core.WarehouseManager;
//FIXME import classes


/**
 * Show partner.
 */
class DoShowPartner extends Command<WarehouseManager> {

  Form _form = new Form();

  DoShowPartner(WarehouseManager receiver) {
    super(Label.SHOW_PARTNER, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException {
    //FIXME implement command
    String id = _form.requestString(Message.requestPartnerKey());
    try{
      Partner p = _receiver.getPartner(id);
      _display.addLine(""+p.getID()+"|"
                          +p.getName()+"|"
                          +p.getAddress()+"|"
                          +p.getStatus()+"|"
                          +p.getPoints()+"|"
                          +Math.round(p.getBought())+"|"
                          +Math.round(p.getSellsDone())+"|"
                          +Math.round(p.getSellsPaid()));
      _display.display();
    }
    catch (UnknownKeyException e){
      throw new UnknownPartnerKeyException(e.getId());
    }
  }

}
