package ggc.app.partners;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.exception.UnknownKeyException;

import java.util.Collection;
import java.util.List;

import ggc.app.exception.UnknownPartnerKeyException;
import ggc.core.Notification;
import ggc.core.Partner;
import ggc.core.WarehouseManager;
//FIXME import classes


/**
 * Show partner.
 */
class DoShowPartner extends Command<WarehouseManager> {

  DoShowPartner(WarehouseManager receiver) {
    super(Label.SHOW_PARTNER, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException {
    //FIXME implement command
    String id = Form.requestString(Message.requestPartnerKey());
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
      Collection<Notification> notifications = _receiver.getNotifications(id);
      if (notifications != null){
        for (Notification notification : notifications)
          _display.addLine(notification.toString());
        _receiver.clearNotifications(id);
      }
      _display.display();

    }
    catch (UnknownKeyException e){
      throw new UnknownPartnerKeyException(e.getId());
    }
  }

}
