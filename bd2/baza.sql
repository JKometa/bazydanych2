/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013-05-23 21:58:54                          */
/*==============================================================*/


drop table if exists Administrator;

drop table if exists Gwarancja;

drop table if exists Gwarant;

drop table if exists Lokalizacja;

drop table if exists "Parametr Numeryczny";

drop table if exists "Parametr Opisowy";

drop table if exists Pracownik;

drop table if exists Rodzaj;

drop table if exists Sie�;

drop table if exists Urz�dzenie;

drop table if exists "Warto�� Parametru Numerycznego";

drop table if exists "Warto�� Parametru Opisowego";

drop table if exists "W�a�ciwo�ci techniczne";

drop table if exists "W�a�ciwo�ci uzytkowe";

drop table if exists "Zesp� serwisowy";

drop table if exists "Zg�oszenie naprawy";

/*==============================================================*/
/* Table: Administrator                                         */
/*==============================================================*/
create table Administrator
(
   AdresSieci           text not null,
   IdPracownika         int,
   IdAdministratora     int not null,
   primary key (IdAdministratora)
);

/*==============================================================*/
/* Table: Gwarancja                                             */
/*==============================================================*/
create table Gwarancja
(
   IdGwarancji          int not null,
   NazwaGwaranta        text not null,
   PoczatekGwarancji    date not null,
   KoniecGwarancji      date not null,
   NumerUmowy           int not null,
   primary key (IdGwarancji)
);

/*==============================================================*/
/* Table: Gwarant                                               */
/*==============================================================*/
create table Gwarant
(
   NazwaGwaranta        text not null,
   Ulica                text not null,
   Miasto               text not null,
   NrLokalu             text not null,
   NrTelefonu           numeric(8,0) not null,
   primary key (NazwaGwaranta)
);

/*==============================================================*/
/* Table: Lokalizacja                                           */
/*==============================================================*/
create table Lokalizacja
(
   IdSprzetu            int not null,
   IdGwarancji          int not null,
   IdLokalizacja        int not null,
   Pokoj                int not null,
   Pietro               int not null,
   Budynek              text not null,
   primary key (IdSprzetu, IdGwarancji, IdLokalizacja)
);

/*==============================================================*/
/* Table: "Parametr Numeryczny"                                 */
/*==============================================================*/
create table "Parametr Numeryczny"
(
   Nazwa                text not null,
   Jednostka            text,
   primary key (Nazwa)
);

/*==============================================================*/
/* Table: "Parametr Opisowy"                                    */
/*==============================================================*/
create table "Parametr Opisowy"
(
   Nazwa                text not null,
   primary key (Nazwa)
);

/*==============================================================*/
/* Table: Pracownik                                             */
/*==============================================================*/
create table Pracownik
(
   IdPracownika         int not null,
   Imie                 text not null,
   Nazwisko             text not null,
   IdZespolu            int,
   Status               text not null,
   primary key (IdPracownika)
);

/*==============================================================*/
/* Table: Rodzaj                                                */
/*==============================================================*/
create table Rodzaj
(
   NazwaRodzaju         text not null,
   Marka                text,
   Model                text,
   primary key (NazwaRodzaju)
);

/*==============================================================*/
/* Table: Sie�                                                  */
/*==============================================================*/
create table Sie�
(
   AdresSieci           text not null,
   IdSprzetu            int not null,
   primary key (AdresSieci)
);

/*==============================================================*/
/* Table: Urz�dzenie                                            */
/*==============================================================*/
create table Urz�dzenie
(
   IdSprzetu            int not null,
   NazwaRodzaju         text not null,
   primary key (IdSprzetu)
);

/*==============================================================*/
/* Table: "Warto�� Parametru Numerycznego"                      */
/*==============================================================*/
create table "Warto�� Parametru Numerycznego"
(
   Nazwa                text not null,
   IdSprzetu            int not null,
   Wartosc              int not null,
   primary key (Nazwa, IdSprzetu)
);

/*==============================================================*/
/* Table: "Warto�� Parametru Opisowego"                         */
/*==============================================================*/
create table "Warto�� Parametru Opisowego"
(
   IdSprzetu            int not null,
   Nazwa                text not null,
   Pole                 text not null,
   primary key (IdSprzetu, Nazwa)
);

/*==============================================================*/
/* Table: "W�a�ciwo�ci techniczne"                              */
/*==============================================================*/
create table "W�a�ciwo�ci techniczne"
(
   Par_Nazwa            text not null,
   Nazwa                text not null,
   NazwaRodzaju         text not null,
   primary key (Par_Nazwa, Nazwa, NazwaRodzaju)
);

/*==============================================================*/
/* Table: "W�a�ciwo�ci uzytkowe"                                */
/*==============================================================*/
create table "W�a�ciwo�ci uzytkowe"
(
   IdSprzetu            int not null,
   IdGwarancji          int not null,
   IdLokalizacja        int not null,
   primary key (IdSprzetu, IdGwarancji, IdLokalizacja)
);

/*==============================================================*/
/* Table: "Zesp� serwisowy"                                    */
/*==============================================================*/
create table "Zesp� serwisowy"
(
   IdZespolu            int not null,
   NazwaZespolu         text not null,
   Opis                 text,
   primary key (IdZespolu)
);

/*==============================================================*/
/* Table: "Zg�oszenie naprawy"                                  */
/*==============================================================*/
create table "Zg�oszenie naprawy"
(
   IdZgloszenia         int not null,
   NazwaGwaranta        text,
   IdSprzetu            int not null,
   IdLokalizacja        int not null,
   IdAdministratora     int,
   IdZespolu            int,
   Status               text not null,
   primary key (IdZgloszenia)
);

alter table Administrator add constraint FK_Jest foreign key (IdPracownika)
      references Pracownik (IdPracownika) on delete restrict on update restrict;

alter table Administrator add constraint FK_Jest_przypisany_do foreign key (AdresSieci)
      references Sie� (AdresSieci) on delete restrict on update restrict;

alter table Gwarancja add constraint FK_Nale�y_do2 foreign key (NazwaGwaranta)
      references Gwarant (NazwaGwaranta) on delete restrict on update restrict;

alter table Lokalizacja add constraint FK_Posiada2 foreign key (IdSprzetu, IdGwarancji, IdLokalizacja)
      references "W�a�ciwo�ci uzytkowe" (IdSprzetu, IdGwarancji, IdLokalizacja) on delete restrict on update restrict;

alter table Pracownik add constraint FK_Nale�y_do foreign key (IdZespolu)
      references "Zesp� serwisowy" (IdZespolu) on delete restrict on update restrict;

alter table Sie� add constraint FK_Jest_podlaczone_do foreign key (IdSprzetu)
      references Urz�dzenie (IdSprzetu) on delete restrict on update restrict;

alter table Urz�dzenie add constraint FK_Posiada foreign key (NazwaRodzaju)
      references Rodzaj (NazwaRodzaju) on delete restrict on update restrict;

alter table "Warto�� Parametru Numerycznego" add constraint FK_Posiada8 foreign key (IdSprzetu)
      references Urz�dzenie (IdSprzetu) on delete restrict on update restrict;

alter table "Warto�� Parametru Numerycznego" add constraint FK_Relationship_18 foreign key (Nazwa)
      references "Parametr Numeryczny" (Nazwa) on delete restrict on update restrict;

alter table "Warto�� Parametru Opisowego" add constraint FK_Posiada7 foreign key (Nazwa)
      references "Parametr Opisowy" (Nazwa) on delete restrict on update restrict;

alter table "Warto�� Parametru Opisowego" add constraint FK_Posiada9 foreign key (IdSprzetu)
      references Urz�dzenie (IdSprzetu) on delete restrict on update restrict;

alter table "W�a�ciwo�ci techniczne" add constraint FK_Posiada3 foreign key (Nazwa)
      references "Parametr Numeryczny" (Nazwa) on delete restrict on update restrict;

alter table "W�a�ciwo�ci techniczne" add constraint FK_Posiada4 foreign key (NazwaRodzaju)
      references Rodzaj (NazwaRodzaju) on delete restrict on update restrict;

alter table "W�a�ciwo�ci techniczne" add constraint FK_Posiada5 foreign key (Par_Nazwa)
      references "Parametr Opisowy" (Nazwa) on delete restrict on update restrict;

alter table "W�a�ciwo�ci uzytkowe" add constraint FK_Ma2 foreign key (IdSprzetu)
      references Urz�dzenie (IdSprzetu) on delete restrict on update restrict;

alter table "W�a�ciwo�ci uzytkowe" add constraint FK_Ma3 foreign key (IdGwarancji)
      references Gwarancja (IdGwarancji) on delete restrict on update restrict;

alter table "Zg�oszenie naprawy" add constraint FK_Jest_przypisane_do foreign key (IdSprzetu)
      references Urz�dzenie (IdSprzetu) on delete restrict on update restrict;

alter table "Zg�oszenie naprawy" add constraint FK_Obsluguje foreign key (IdZespolu)
      references "Zesp� serwisowy" (IdZespolu) on delete restrict on update restrict;

alter table "Zg�oszenie naprawy" add constraint FK_Obs�uguje2 foreign key (NazwaGwaranta)
      references Gwarant (NazwaGwaranta) on delete restrict on update restrict;

alter table "Zg�oszenie naprawy" add constraint FK_Relationship_10 foreign key (IdLokalizacja)
      references Lokalizacja (IdLokalizacja) on delete restrict on update restrict;

alter table "Zg�oszenie naprawy" add constraint FK_Relationship_23 foreign key (IdAdministratora)
      references Administrator (IdAdministratora) on delete restrict on update restrict;

