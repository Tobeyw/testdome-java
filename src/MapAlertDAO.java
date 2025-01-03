import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class AlertService {
   // private final AlertDAO storage = new MapAlertDAO();
		
    private final AlertDAO storage;
    public AlertService(AlertDAO alertDAO) {
        this.storage = alertDAO;
    }
    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }
	
    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }	
}

class MapAlertDAO implements AlertDAO{
    private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();
	
    public UUID addAlert(Date time) {
    	UUID id = UUID.randomUUID();
        this.alerts.put(id, time);
        return id;
    }
	
    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }	
}

interface  AlertDAO {
    public UUID addAlert(Date time);
    public Date getAlert(UUID id);
}	
