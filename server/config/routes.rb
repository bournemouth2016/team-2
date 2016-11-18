Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  root 'overviews#home'

  #incidence
  get    'incidences' => 'incidences#index'
  get    'setting' => 'incidences#setting'
  get    'today' => 'incidences#today'
  get    'newest' => 'incidences#newest'
  get    'all' => 'incidences#all'
  get    'calendar' => 'incidences#calendar'
  get    'search' => 'incidences#search'
end
