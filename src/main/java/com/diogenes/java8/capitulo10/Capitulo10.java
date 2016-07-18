package com.diogenes.java8.capitulo10;

import jdk.nashorn.internal.objects.NativeJava;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by diogenes on 18/07/16.
 */
public class Capitulo10 {
    public static void main(String[] args) {

        //Forma antiga
        Calendar mesQueVem = Calendar.getInstance();
        mesQueVem.add(Calendar.MONTH, 1);

        //Representa uma data sem horario e timezone
        LocalDate mesQueVemNovo = LocalDate.now().plusMonths(1);
        LocalDate.now().plusDays(2);
        LocalDate.now().plusYears(2);

        System.out.println(mesQueVemNovo);

        //Data e Hora
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);

        //Somente Hora
        LocalTime horaAgora = LocalTime.now();
        System.out.println(horaAgora);

        //Criar uma data com um horario especifico
        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12, 0);

        LocalDateTime dataEHora = LocalDate.now().atTime(LocalTime.now());

        //Com timezone
        ZonedDateTime dataComHoraETimezone = dataEHora.atZone(ZoneId.of("America/Sao_Paulo"));

        //Conversao entre os tipos - metodos toXXX
        dataComHoraETimezone.toLocalDateTime();

        //factory metodo of

        LocalDate date = LocalDate.of(2014, 12, 25);
        LocalDateTime dateTime = LocalDateTime.of(2014, 12, 25, 10, 30);

        //O modelo do java.time é imutável
        LocalDate dataDoPassado = LocalDate.now().withYear(1988);
        System.out.println(dataDoPassado.getYear());

        //métodos is
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);

        System.out.println(hoje.isBefore(amanha));
        System.out.println(hoje.isAfter(amanha));
        System.out.println(hoje.isEqual(amanha));

        ZonedDateTime tokyo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
        ZonedDateTime saoPaulo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));

        //Sera falso
        System.out.println(tokyo.isEqual(saoPaulo));

        //Sera falso
        System.out.println(tokyo.equals(saoPaulo));

        //Temos que ajustar a diferenca de horario para poder comparar
        tokyo = tokyo.plusHours(12);

        //Sera true
        System.out.println(tokyo.isEqual(saoPaulo));

        System.out.println("hoje é dia: " + MonthDay.now().getDayOfMonth());

        YearMonth ym = YearMonth.from(LocalDate.now());
        System.out.println(ym.getMonth() + " " + ym.getYear());

        System.out.println("Ano é bisexto: " + Year.now().isLeap());

        //Enums
        System.out.println(Month.DECEMBER.firstMonthOfQuarter());

        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, new Locale("pt")));

        System.out.println(DayOfWeek.FRIDAY);

        //Formatacao
        agora = LocalDateTime.now();
        String resultado = agora.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(resultado);

        System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        //parse
        String data = "18/07/2016";
        System.out.println(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        //Data Invalidas lança DateTimeException - O Calendar incrementa as datas
        LocalDate.of(2014, Month.FEBRUARY, 30);



    }
}
