package ggc.app.partners;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import ggc.app.exception.UnknownPartnerKeyException;
import ggc.app.exception.UnknownProductKeyException;
import ggc.core.WarehouseManager;
//FIXME import classes
import ggc.core.exception.UnknownKeyException;

/**
 * Toggle product-related notifications.
 */
class DoToggleProductNotifications extends Command<WarehouseManager> {

  DoToggleProductNotifications(WarehouseManager receiver) {
    super(Label.TOGGLE_PRODUCT_NOTIFICATIONS, receiver);
    //FIXME add command fields
  }

  @Override
  public void execute() throws CommandException, UnknownProductKeyException {

    String partnerID = Form.requestString(Message.requestPartnerKey());
    String productID = Form.requestString(Message.requestProductKey());
    try{
      _receiver.toggleNotification(productID, partnerID);
    }catch(UnknownKeyException e){
      if (e.getId().equals(productID))throw new UnknownProductKeyException(e.getId());
      if (e.getId().equals(partnerID))throw new UnknownPartnerKeyException(e.getId());
    }
  }

}
