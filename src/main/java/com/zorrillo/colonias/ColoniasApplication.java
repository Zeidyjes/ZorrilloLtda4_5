package com.zorrillo.colonias;

//import com.zorrillo.colonias.modelo.Fragance;
//import com.zorrillo.colonias.modelo.Order;
//import com.zorrillo.colonias.modelo.User;
import com.zorrillo.colonias.interfaces.InterfaceOrder;
import com.zorrillo.colonias.interfaces.InterfaceUser;
import com.zorrillo.colonias.interfaces.InterfaceFragance;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColoniasApplication implements CommandLineRunner {

    @Autowired
    private InterfaceFragance interfaceFragance;
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder interfaceOrder;

    public static void main(String[] args) {
        SpringApplication.run(ColoniasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //para efectos de formateo de fechas
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        interfaceFragance.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();

    }
}
