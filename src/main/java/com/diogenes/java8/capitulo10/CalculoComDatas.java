package com.diogenes.java8.capitulo10;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by diogenes on 20/07/16.
 */
public class CalculoComDatas {
    public static void main(String[] args) {
        LocalDate agora = LocalDate.now();
        LocalDate outraData = LocalDate.of(1986, Month.DECEMBER, 8);
        long dias = ChronoUnit.DAYS.between(outraData, agora);
        long meses = ChronoUnit.MONTHS.between(outraData, agora);
        long anos = ChronoUnit.YEARS.between(outraData, agora);

        System.out.println("Dias desde do meu nascimento: " + dias);
        System.out.println("Meses desde do meu nascimento: " + meses);
        System.out.println("Anos desde do meu nascimento: " + anos);

        Period periodo = Period.between(outraData, agora);
        System.out.printf("%s dias, %s meses e %s anos\n", periodo.getDays(),
                periodo.getMonths(),
                periodo.getYears());

        //outros métodos de Period
        periodo.isNegative();
        periodo.negated();
        Period.of(2015, 7, 20);
        Period.ofDays(15);
        Period.ofMonths(5);
        Period.ofYears(25);

        //Duration para medidas de tempo
        LocalDateTime agoraComHora = LocalDateTime.now();
        LocalDateTime daquiUmaHora = LocalDateTime.now().plusHours(1);
        Duration duration = Duration.between(agoraComHora, daquiUmaHora);

        System.out.printf("%s horas, %s minutos e %s segundos",
                duration.toHours(), duration.toMinutes(), duration.getSeconds());

    }
}
