package ggc.app.partners;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
import ggc.core.exception.DuplicateKeyException;
import ggc.app.exception.DuplicatePartnerKeyException;

//FIXME import classes

/**
 * Register new partner.
 */
class DoRegisterPartner extends Command<WarehouseManager> {

  DoRegisterPartner(WarehouseManager receiver) {
    super(Label.REGISTER_PARTNER, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException {
    String id = Form.requestString(Message.requestPartnerKey());
    String name = Form.requestString(Message.requestPartnerName());
    String address = Form.requestString(Message.requestPartnerAddress());
    try{
      _receiver.registerPartner(name, address, id);
    } catch (DuplicateKeyException e){
      throw new DuplicatePartnerKeyException(e.getKey());
    }
  }

}
