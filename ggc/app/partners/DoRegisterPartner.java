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

  Form _form = new Form();

  DoRegisterPartner(WarehouseManager receiver) {
    super(Label.REGISTER_PARTNER, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException {
    String id = _form.requestString(Message.requestPartnerKey());
    String name = _form.requestString(Message.requestPartnerName());
    String address = _form.requestString(Message.requestPartnerAddress());
    try{
      _receiver.registerPartner(name, address, id);
    } catch (DuplicateKeyException e){
      throw new DuplicatePartnerKeyException(e.getKey());
    }
  }

}
